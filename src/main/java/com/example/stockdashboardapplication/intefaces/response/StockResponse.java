package com.example.stockdashboardapplication.intefaces.response;

import com.example.stockdashboardapplication.intefaces.dto.StockDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class StockResponse {
    private List<StockDto> stockDtoList;
}
