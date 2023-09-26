package com.example.stockdashboardapplication.intefaces.response;


import com.example.stockdashboardapplication.intefaces.dto.CsvStockData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DailyStockDataResponse {

    private List<CsvStockData> csvStockData;
}
