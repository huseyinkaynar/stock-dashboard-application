package com.example.stockdashboardapplication.domain.service;

import com.example.stockdashboardapplication.intefaces.dto.HandlerDto;
import com.example.stockdashboardapplication.intefaces.dto.StockDto;
import com.example.stockdashboardapplication.intefaces.request.StockRequest;
import com.example.stockdashboardapplication.intefaces.response.CommonStockResponse;
import com.example.stockdashboardapplication.intefaces.response.StockResponse;

public interface StockService {
    StockResponse getStocks();
    CommonStockResponse saveStocks(StockRequest stockRequest);
    StockDto getStockByName(String stockId);
    void countStocks(HandlerDto handlerDto);
}
