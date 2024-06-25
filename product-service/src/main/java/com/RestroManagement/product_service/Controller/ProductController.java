package com.RestroManagement.product_service.Controller;

import com.RestroManagement.product_service.DTO.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createproduct(@RequestBody ProductDto productDto){

    }
}
