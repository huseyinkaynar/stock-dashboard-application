package com.example.stockdashboardapplication.domain.service.imp;

import com.example.stockdashboardapplication.domain.service.StockService;
import com.example.stockdashboardapplication.domain.service.strategy.StockCountStrategy;
import com.example.stockdashboardapplication.infrastructure.entity.StockEntity;
import com.example.stockdashboardapplication.infrastructure.repository.StockRepository;
import com.example.stockdashboardapplication.intefaces.dto.HandlerDto;
import com.example.stockdashboardapplication.intefaces.dto.StockDto;
import com.example.stockdashboardapplication.intefaces.mapper.StockMapper;
import com.example.stockdashboardapplication.intefaces.request.StockRequest;
import com.example.stockdashboardapplication.intefaces.response.CommonStockResponse;
import com.example.stockdashboardapplication.intefaces.response.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImp implements StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;
    private final StockCountStrategy strategy;
    @Override
    public StockResponse getStocks() {
        List<StockDto> stockDtoList = stockMapper.toStockDtoList(stockRepository.findAll());

        return StockResponse.builder().stockDtoList(stockDtoList).build();
    }

    @Override
    public CommonStockResponse saveStocks(StockRequest stockRequest) {
        List<StockEntity> stockEntityList = stockMapper.toStockEntityList(stockRequest.getStockDtoList());
        stockRepository.saveAll(stockEntityList);

        return CommonStockResponse.builder().message("Kayıt Başarılı").build();
    }

    @Override
    public StockDto getStockByName(String stockName) {
        return stockMapper.toStockDto(stockRepository.findByStockName(stockName));
    }

    @Override
    public void countStocks(HandlerDto handlerDto) {
        strategy.count(handlerDto);
    }
}
