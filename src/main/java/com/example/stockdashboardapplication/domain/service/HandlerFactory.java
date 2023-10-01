package com.example.stockdashboardapplication.domain.service;

import com.example.stockdashboardapplication.domain.enums.HandlerType;
import com.example.stockdashboardapplication.domain.service.handler.CalculateStocksHandler;
import com.example.stockdashboardapplication.domain.service.handler.CompleteStockHandler;
import com.example.stockdashboardapplication.domain.service.handler.GetStocksHandler;
import org.springframework.stereotype.Service;

@Service
public class HandlerFactory {

    public Handler create(HandlerType handlerType){
        switch (handlerType){
            case GET_STOCKS:
                return new GetStocksHandler();
            case CALCULATE_STOCKS:
                return new CalculateStocksHandler();
            case COMPLETE_STOCK_HANDLER:
                return new CompleteStockHandler();
            default:
                throw new IllegalArgumentException("Invalid handler type: " + handlerType);
        }
    }
}
