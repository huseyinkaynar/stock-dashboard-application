package com.example.stockdashboardapplication.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CsvStockData {

    private String stockName;
    private String lastPrice;
    private String percentChange;
    private String turkishLiraChange;
    private String turkishLiraTradingVolume;
    private String pieceTradingVolume;

}
