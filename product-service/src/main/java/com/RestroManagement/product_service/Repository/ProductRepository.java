package com.RestroManagement.product_service.Repository;

import com.RestroManagement.product_service.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
