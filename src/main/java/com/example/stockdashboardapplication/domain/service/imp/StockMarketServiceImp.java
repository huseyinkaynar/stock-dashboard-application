package com.example.stockdashboardapplication.domain.service.imp;

import com.example.stockdashboardapplication.intefaces.dto.CsvStockData;
import com.example.stockdashboardapplication.intefaces.request.DailyStockDataRequest;
import com.example.stockdashboardapplication.intefaces.request.GeneratedDailyStockRequest;
import com.example.stockdashboardapplication.intefaces.response.DailyStockDataResponse;
import com.example.stockdashboardapplication.intefaces.response.CommonStockResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.stockdashboardapplication.domain.service.StockMarketService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StockMarketServiceImp implements StockMarketService {

    @Value("${isYatirimUrl}")
    public String isYatirimUrl;

    public final static String CSV_PATH;

    private static final String CSV_SEPARATOR = ";";

    static {
        File file = new File("csv/web_table.csv");
        String targetFolderPath = file.getAbsolutePath();
        CSV_PATH= targetFolderPath;
    }

    @Override
    public CommonStockResponse generateDailyStockMarketDataCsv(GeneratedDailyStockRequest stockRequest) {
        CommonStockResponse commonStockResponse = null;
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
                    csvWriter.append(column.text()).append(CSV_SEPARATOR);
                }
                csvWriter.append("\n");
            }

            // Satırları al
            Elements dataRows = table.select("tbody tr");
            for (Element row : dataRows) {
                Elements dataColumns = row.select("td");
                for (Element column : dataColumns) {
                    csvWriter.append(column.text()).append(CSV_SEPARATOR);
                }
                csvWriter.append("\n");
            }

            // CSV dosyasını kapat
            csvWriter.flush();
            csvWriter.close();

            // CSV dosyasını hedef klasöre taşı
            Path sourcePath = Path.of("web_table.csv");
            Path targetPath = Path.of(CSV_PATH);
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

            commonStockResponse = CommonStockResponse.builder().message("Tablo CSV olarak çekildi.").build();
        } catch (IOException e) {
            e.printStackTrace();
            commonStockResponse = CommonStockResponse.builder().message("Tablo CSV oluşturulurken hata oluştu.").build();
        }

        return commonStockResponse;
    }

    @Override
    public DailyStockDataResponse findDailyDataOfStocksCsv(DailyStockDataRequest dailyStockDataRequest) {

        List<CsvStockData> csvStockDataList=new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);
                for (String value : data) {
                    if (dailyStockDataRequest.getStockNames().contains(value)) {
                        csvStockDataList.add(
                                CsvStockData.builder().
                                stockName(data[0]).
                                lastPrice(data[1]).
                                percentChange(data[2]).
                                turkishLiraChange(data[3]).
                                turkishLiraTradingVolume(data[4]).
                                pieceTradingVolume(data[5]).
                                build());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return DailyStockDataResponse.
                builder().
                csvStockData(csvStockDataList).
                build();
    }
}
