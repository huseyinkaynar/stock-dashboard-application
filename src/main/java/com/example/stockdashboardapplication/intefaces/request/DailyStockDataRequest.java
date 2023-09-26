package com.example.stockdashboardapplication.intefaces.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DailyStockDataRequest {

    List<String> stockNames;
}
