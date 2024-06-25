package com.RestroManagement.product_service.repository;

import com.RestroManagement.product_service.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product,String>{
}
