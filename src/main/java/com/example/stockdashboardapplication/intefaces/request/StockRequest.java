package com.example.stockdashboardapplication.intefaces.request;

import com.example.stockdashboardapplication.intefaces.dto.StockDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class StockRequest {
    @NotEmpty
    @Valid
    private List<StockDto> stockDtoList;
    private LocalDateTime sendDate;
}
