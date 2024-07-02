package com.RestroManagement.product_service.Controller;

import com.RestroManagement.product_service.DTO.ApiResponce;
import com.RestroManagement.product_service.DTO.ProductDto;
import com.RestroManagement.product_service.DTO.ProductResponce;
import com.RestroManagement.product_service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/UpdateProduct/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Integer id) {
        ProductDto updatedProduct = this.productService.updateProduct(productDto, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<ApiResponce> deleteProduct(@PathVariable Integer id) {
        String deleteMessage = this.productService.deleteProductById(id);
        return new ResponseEntity<>(new ApiResponce(deleteMessage, true), HttpStatus.OK);
    }

}
