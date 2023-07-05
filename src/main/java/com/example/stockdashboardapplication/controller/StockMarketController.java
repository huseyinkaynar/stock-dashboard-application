package com.example.stockdashboardapplication.controller;

import com.example.stockdashboardapplication.model.StockRequest;
import com.example.stockdashboardapplication.model.StockResponse;
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
    public StockResponse generateDailyStockMarketData(@RequestBody StockRequest stockRequest){
        return stockMarketService.generateDailyStockMarketDataCsv(stockRequest);
    }


}
