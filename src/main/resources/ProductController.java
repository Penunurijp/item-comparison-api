package com.meli.challenge.item_comparison_api.controller;

import com.meli.challenge.item_comparison_api.model.Product;
import com.meli.challenge.item_comparison_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/compare")
    public ResponseEntity<?> getProductsById(@RequestParam List<String> id) {
        if(id.isEmpty()){
            return ResponseEntity.badRequest().body("At least one product ID must be provided.");
        }
        List <Product> products = productService.getProductsById(id);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productService.getProductsById(id));
    }
}
