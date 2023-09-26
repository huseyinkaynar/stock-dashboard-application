package com.example.stockdashboardapplication.intefaces.mapper;

import com.example.stockdashboardapplication.infrastructure.entity.StockEntity;
import com.example.stockdashboardapplication.intefaces.dto.StockDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StockMapper {

    StockEntity toStockEntity(StockDto stockDto);

    StockDto toStockDto(StockEntity stockEntity);

    List<StockEntity> toStockEntityList(List<StockDto> stockDto);

    List<StockDto> toStockDtoList(List<StockEntity> stockEntityList);

}
