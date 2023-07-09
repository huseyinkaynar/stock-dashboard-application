package com.example.stockdashboardapplication.service;

import com.example.stockdashboardapplication.model.request.DailyStockDataRequest;
import com.example.stockdashboardapplication.model.request.GeneratedDailyStockRequest;
import com.example.stockdashboardapplication.model.response.DailyStockDataResponse;
import com.example.stockdashboardapplication.model.response.GeneratedDailyStockResponse;

public interface StockMarketService {

    GeneratedDailyStockResponse generateDailyStockMarketDataCsv(GeneratedDailyStockRequest stockRequest);

    DailyStockDataResponse findDailyDataOfStocksCsv(DailyStockDataRequest dailyStockDataRequest);
}
