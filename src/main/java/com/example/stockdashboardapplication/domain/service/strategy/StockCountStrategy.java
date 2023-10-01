package com.example.stockdashboardapplication.domain.service.strategy;


import com.example.stockdashboardapplication.domain.enums.HandlerType;
import com.example.stockdashboardapplication.domain.service.Handler;
import com.example.stockdashboardapplication.domain.service.HandlerFactory;
import com.example.stockdashboardapplication.intefaces.dto.HandlerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockCountStrategy {
    private final HandlerFactory handlerFactory;

    public void count(HandlerDto handlerDto) {
        final Handler getStockHandler = handlerFactory.create(HandlerType.GET_STOCKS);
        final Handler calculateStockHandler = handlerFactory.create(HandlerType.CALCULATE_STOCKS);
        final Handler completeStockHandler = handlerFactory.create(HandlerType.COMPLETE_STOCK_HANDLER);

        getStockHandler.setSuccessor(calculateStockHandler);
        calculateStockHandler.setSuccessor(completeStockHandler);
        getStockHandler.handle(handlerDto);
    }
    }
