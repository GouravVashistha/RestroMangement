package com.RestroManagement.product_service.Entity;
import jakarta.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductEntityListener {

    private static final Logger logger = LoggerFactory.getLogger(ProductEntityListener.class);

    @PrePersist
    public void prePersist(Product product) {
        logger.info("About to create Product: " + product);
    }

    @PostPersist
    public void postPersist(Product product) {
        logger.info("Created Product: " + product);
    }

    @PreUpdate
    public void preUpdate(Product product) {
        logger.info("About to update Product: " + product);
    }

    @PostUpdate
    public void postUpdate(Product product) {
        logger.info("Updated Product: " + product);
    }

    @PreRemove
    public void preRemove(Product product) {
        logger.info("About to delete Product: " + product);
    }

    @PostRemove
    public void postRemove(Product product) {
        logger.info("Deleted Product: " + product);
    }
}