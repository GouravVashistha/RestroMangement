package com.example.RestroMangement.inventory_service.Serviceimpl;

import com.example.RestroMangement.inventory_service.Repository.InventoryRepository;
import com.example.RestroMangement.inventory_service.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public Boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

}
