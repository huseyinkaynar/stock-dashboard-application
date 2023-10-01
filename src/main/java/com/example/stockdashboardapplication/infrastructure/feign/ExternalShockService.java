package com.example.stockdashboardapplication.infrastructure.feign;

import com.example.stockdashboardapplication.intefaces.dto.ExternalStockDto;
import com.example.stockdashboardapplication.intefaces.request.ExternalStockRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient (name = "insurance-client",
        url = "${external-insurance-client-url}",
        configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface ExternalShockService {
    @PostMapping("/GET_STOCK")
    ExternalStockDto getStock(@RequestBody ExternalStockRequest request);

}

