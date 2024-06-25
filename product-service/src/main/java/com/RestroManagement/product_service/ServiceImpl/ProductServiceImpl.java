package com.RestroManagement.product_service.ServiceImpl;

import com.RestroManagement.product_service.DTO.ProductDto;
import com.RestroManagement.product_service.Entity.Product;
import com.RestroManagement.product_service.Repository.ProductRepository;
import com.RestroManagement.product_service.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // Convert ProductDto to Product entity
        Product product = this.modelMapper.map(productDto, Product.class);

        // Save the Product entity to the repository
        Product addProduct = this.productRepository.save(product);

        // Convert the saved Product entity back to ProductDto
        return this.modelMapper.map(addProduct, ProductDto.class);
    }
}
