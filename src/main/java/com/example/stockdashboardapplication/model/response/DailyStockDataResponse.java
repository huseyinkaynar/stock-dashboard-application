package com.example.stockdashboardapplication.model.response;


import com.example.stockdashboardapplication.model.dto.CsvStockData;
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
