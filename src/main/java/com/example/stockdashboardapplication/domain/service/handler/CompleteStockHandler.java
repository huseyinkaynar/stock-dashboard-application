package com.example.stockdashboardapplication.domain.service.handler;

import com.example.stockdashboardapplication.domain.service.Handler;
import com.example.stockdashboardapplication.intefaces.dto.HandlerDto;

public class CompleteStockHandler implements Handler {

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handle(HandlerDto application) {
        System.out.println("CompleteStockHandler");
        if (successor != null) successor.handle(application);
    }
}
