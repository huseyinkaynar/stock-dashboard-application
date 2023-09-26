package com.example.stockdashboardapplication.domain.service;

import com.example.stockdashboardapplication.intefaces.request.DailyStockDataRequest;
import com.example.stockdashboardapplication.intefaces.request.GeneratedDailyStockRequest;
import com.example.stockdashboardapplication.intefaces.response.DailyStockDataResponse;
import com.example.stockdashboardapplication.intefaces.response.CommonStockResponse;

public interface StockMarketService {

    CommonStockResponse generateDailyStockMarketDataCsv(GeneratedDailyStockRequest stockRequest);

    DailyStockDataResponse findDailyDataOfStocksCsv(DailyStockDataRequest dailyStockDataRequest);
}
