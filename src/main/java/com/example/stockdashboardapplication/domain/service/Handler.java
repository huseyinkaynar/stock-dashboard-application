package com.example.stockdashboardapplication.domain.service;

import com.example.stockdashboardapplication.intefaces.dto.HandlerDto;

public interface Handler {
    void setSuccessor(Handler successor);

    void handle(HandlerDto application);
}
