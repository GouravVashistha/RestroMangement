package com.RestroManagement.product_service.ServiceImpl;

import com.RestroManagement.product_service.DTO.ProductDto;
import com.RestroManagement.product_service.DTO.ProductResponce;
import com.RestroManagement.product_service.Entity.Product;
import com.RestroManagement.product_service.Exceptions.ResourceNotFoundException;
import com.RestroManagement.product_service.Repository.ProductRepository;
import com.RestroManagement.product_service.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // Convert ProductDto to Product entity
        Product product = this.modelMapper.map(productDto, Product.class);

        // Save the Product entity to the repository
        Product addProduct = this.productRepository.save(product);
        log.info("Product saved");

        // Convert the saved Product entity back to ProductDto
        return this.modelMapper.map(addProduct, ProductDto.class);
    }

    public List<ProductResponce> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> prodDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());

        List<ProductResponce> productResponses = prodDtos.stream()
                .map(dto -> modelMapper.map(dto, ProductResponce.class))
                .collect(Collectors.toList());

        return productResponses;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer id) {
        Product existingProduct = this.productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product", "Product Id", id));

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());

        Product updatedProduct = this.productRepository.save(existingProduct);
        return  this.modelMapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public String deleteProductById(Integer id) {
        Product existingProduct  = this.productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("product", "Product Id", id));
        productRepository.deleteById(id);
        return "Product Is deleted Successfully......!";
    }

}
