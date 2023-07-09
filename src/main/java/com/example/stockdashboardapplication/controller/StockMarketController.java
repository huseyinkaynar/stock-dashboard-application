package com.example.stockdashboardapplication.controller;

import com.example.stockdashboardapplication.model.request.DailyStockDataRequest;
import com.example.stockdashboardapplication.model.request.GeneratedDailyStockRequest;
import com.example.stockdashboardapplication.model.response.DailyStockDataResponse;
import com.example.stockdashboardapplication.model.response.GeneratedDailyStockResponse;
import org.springframework.web.bind.annotation.*;
import com.example.stockdashboardapplication.service.StockMarketService;
import com.example.stockdashboardapplication.service.imp.StockMarketServiceImp;

@RestController
public class StockMarketController {

    private final StockMarketService stockMarketService;

    public StockMarketController(StockMarketServiceImp stockMarketService) {
        this.stockMarketService=stockMarketService;
    }

    @PostMapping(path = "/generate")
    public GeneratedDailyStockResponse generateDailyStockMarketData(@RequestBody GeneratedDailyStockRequest stockRequest){
        return stockMarketService.generateDailyStockMarketDataCsv(stockRequest);
    }

    @PostMapping(path = "/find-daily-data")
    public DailyStockDataResponse findDailyDataOfStocks(@RequestBody DailyStockDataRequest dailyStockDataRequest){
        return stockMarketService.findDailyDataOfStocksCsv(dailyStockDataRequest);
    }


}
