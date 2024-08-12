package com.example.RestroMangement.inventory_service.Repository;

import com.example.RestroMangement.inventory_service.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
