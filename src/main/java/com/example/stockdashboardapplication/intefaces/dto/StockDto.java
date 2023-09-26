package com.example.stockdashboardapplication.intefaces.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {
    @NotBlank(message = "Stock name cannot be blank")
    private String stockName;
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "Average cost should be a valid number with up to 2 decimal places")
    private String averageCost;
    @PositiveOrZero(message = "Number of pieces should be a positive or zero value")
    private int quantity;
}
