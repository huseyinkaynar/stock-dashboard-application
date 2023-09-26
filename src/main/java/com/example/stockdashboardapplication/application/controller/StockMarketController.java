package com.example.stockdashboardapplication.application.controller;

import com.example.stockdashboardapplication.intefaces.request.DailyStockDataRequest;
import com.example.stockdashboardapplication.intefaces.request.GeneratedDailyStockRequest;
import com.example.stockdashboardapplication.intefaces.response.DailyStockDataResponse;
import com.example.stockdashboardapplication.intefaces.response.CommonStockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.stockdashboardapplication.domain.service.StockMarketService;

@RestController
@RequiredArgsConstructor
public class StockMarketController {

    private final StockMarketService stockMarketService;

    @PostMapping(path = "/generate")
    public CommonStockResponse generateDailyStockMarketData(@RequestBody GeneratedDailyStockRequest stockRequest){
        return stockMarketService.generateDailyStockMarketDataCsv(stockRequest);
    }

    @PostMapping(path = "/find-daily-data")
    public DailyStockDataResponse findDailyDataOfStocks(@RequestBody DailyStockDataRequest dailyStockDataRequest){
        return stockMarketService.findDailyDataOfStocksCsv(dailyStockDataRequest);
    }


}
