package com.example.stockdashboardapplication.domain.service.handler;

import com.example.stockdashboardapplication.domain.service.Handler;
import com.example.stockdashboardapplication.intefaces.dto.HandlerDto;

public class GetStocksHandler implements Handler {

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handle(HandlerDto application) {
        System.out.println("GetstocksHandler");
        if (successor != null) successor.handle(application);
    }
}
