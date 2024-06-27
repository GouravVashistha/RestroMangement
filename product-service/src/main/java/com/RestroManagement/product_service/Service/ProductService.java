package com.RestroManagement.product_service.Service;

import com.RestroManagement.product_service.DTO.ProductDto;
import com.RestroManagement.product_service.DTO.ProductResponce;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto) throws Exception;
    List<ProductResponce> getAllProduct();
}
