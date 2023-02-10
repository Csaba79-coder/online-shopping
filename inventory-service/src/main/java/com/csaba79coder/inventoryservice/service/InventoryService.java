package com.csaba79coder.inventoryservice.service;

import com.csaba79coder.inventoryservice.dto.InventoryResponse;
import com.csaba79coder.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    // @SneakyThrows // for not using try catch or not throwing exception for demo purpose
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        /*log.info("Wait started");
        Thread.sleep(10000);
        log.info("Wait ended");*/
        return inventoryRepository.findInventoryBySkuCodeIn(skuCodes).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}
