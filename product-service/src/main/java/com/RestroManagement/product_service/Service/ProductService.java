package com.RestroManagement.product_service.Service;

import com.RestroManagement.product_service.DTO.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto) throws Exception;
}
