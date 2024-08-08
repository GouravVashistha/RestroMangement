package com.example.RestroMangement.inventory_service.Serviceimpl;

import com.example.RestroMangement.inventory_service.Repository.InventoryRepository;
import com.example.RestroMangement.inventory_service.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Boolean isInStock(String skuCode) {
        return null;
    }
}
