package com.example.stockdashboardapplication.service;

import com.example.stockdashboardapplication.model.StockRequest;
import com.example.stockdashboardapplication.model.StockResponse;

public interface StockMarketService {

    StockResponse generateDailyStockMarketDataCsv(StockRequest stockRequest);
}
