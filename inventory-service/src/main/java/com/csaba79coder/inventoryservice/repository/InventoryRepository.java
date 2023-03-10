package com.csaba79coder.inventoryservice.repository;

import com.csaba79coder.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findInventoryBySkuCodeIn(List<String> skuCode);
}
