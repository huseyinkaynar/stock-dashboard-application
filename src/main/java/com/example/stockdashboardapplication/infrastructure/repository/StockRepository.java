package com.example.stockdashboardapplication.infrastructure.repository;

import com.example.stockdashboardapplication.infrastructure.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity,String > {
    StockEntity findByStockName(String stockName);
}
