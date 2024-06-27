package com.RestroManagement.product_service.Controller;

import com.RestroManagement.product_service.DTO.ProductDto;
import com.RestroManagement.product_service.DTO.ProductResponce;
import com.RestroManagement.product_service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto productDto) throws Exception {
        return productService.createProduct(productDto);
    }

    @GetMapping("/getAllProductList")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponce> getAllProduct(){
        return productService.getAllProduct();
    }

}
