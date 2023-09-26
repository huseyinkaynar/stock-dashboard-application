package com.example.stockdashboardapplication.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Table(name = "STOCK")
@Entity
public class StockEntity {
    @Id
    @Column
    private String stockSymbol;

    @Column
    private String stockName;

    @Column
    private String averageCost;

    @Column
    private int quantity;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyStockPriceEntity> dailyStockPrices;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "last_modified_date", nullable = false)
    @UpdateTimestamp
    private Date lastModifiedDate;
}
