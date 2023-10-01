package com.example.stockdashboardapplication.application.controller;

import com.example.stockdashboardapplication.domain.service.StockService;
import com.example.stockdashboardapplication.domain.service.strategy.StockCountStrategy;
import com.example.stockdashboardapplication.intefaces.dto.HandlerDto;
import com.example.stockdashboardapplication.intefaces.dto.StockDto;
import com.example.stockdashboardapplication.intefaces.request.StockRequest;
import com.example.stockdashboardapplication.intefaces.response.CommonStockResponse;
import com.example.stockdashboardapplication.intefaces.response.StockResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private final StockCountStrategy strategy;

    @GetMapping
    public StockResponse getStocks(){
        return stockService.getStocks();
    }

    @PostMapping
    public CommonStockResponse saveStocks(@RequestBody @Valid StockRequest stockRequest){
        return stockService.saveStocks(stockRequest);
    }

    @GetMapping("/{stockName}")
    public StockDto getStockById(@PathVariable String stockName){
        return stockService.getStockByName(stockName);
    }

    @PostMapping("/count")
    public void saveStocks(@RequestBody @Valid HandlerDto handlerDto){
        stockService.countStocks(handlerDto);
    }

}
