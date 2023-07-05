package com.example.stockdashboardapplication.service.imp;

import com.example.stockdashboardapplication.model.StockRequest;
import com.example.stockdashboardapplication.model.StockResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.stockdashboardapplication.service.StockMarketService;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class StockMarketServiceImp implements StockMarketService {

    @Value("${isYatirimUrl}")
    public String isYatirimUrl;

    @Override
    public StockResponse generateDailyStockMarketDataCsv(StockRequest stockRequest) {
        StockResponse stockResponse=new StockResponse();
        String targetFolderPath = "/Users/huseyink/Desktop/stock-dashboard-application/csv";

        try {
            // Sayfayı Jsoup ile al
            Document document = Jsoup.connect(isYatirimUrl).get();

            // CSV dosyasını oluştur
            FileWriter csvWriter = new FileWriter("web_table.csv");

            // Tabloyu bul
            Element table = document.select("table.dataTable").first();

            // Başlıkları al
            Elements headerRows = Objects.requireNonNull(table).select("thead tr");
            for (Element row : headerRows) {
                Elements headerColumns = row.select("th");
                for (Element column : headerColumns) {
                    csvWriter.append(column.text()).append(",");
                }
                csvWriter.append("\n");
            }

            // Satırları al
            Elements dataRows = table.select("tbody tr");
            for (Element row : dataRows) {
                Elements dataColumns = row.select("td");
                for (Element column : dataColumns) {
                    csvWriter.append(column.text()).append(",");
                }
                csvWriter.append("\n");
            }

            // CSV dosyasını kapat
            csvWriter.flush();
            csvWriter.close();

            // CSV dosyasını hedef klasöre taşı
            Path sourcePath = Path.of("web_table.csv");
            Path targetPath = Path.of(targetFolderPath, "web_table.csv");
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);


            stockResponse.setMessage("Tablo CSV olarak çekildi.");
        } catch (IOException e) {
            e.printStackTrace();
            stockResponse.setMessage("Tablo CSV oluşturulurken hata oluştu.");
        }

        return stockResponse;
    }
}
