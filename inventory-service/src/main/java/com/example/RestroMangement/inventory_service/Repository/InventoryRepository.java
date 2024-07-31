package com.example.RestroMangement.inventory_service.Repository;

import com.example.RestroMangement.inventory_service.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
