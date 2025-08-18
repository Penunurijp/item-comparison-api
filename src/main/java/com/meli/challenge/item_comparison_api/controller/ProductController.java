package com.meli.challenge.item_comparison_api.controller;

import com.meli.challenge.item_comparison_api.exception.EmptyListException;
import com.meli.challenge.item_comparison_api.exception.NotFoundException;
import com.meli.challenge.item_comparison_api.model.Product;
import com.meli.challenge.item_comparison_api.service.ProductService;
import org.apache.coyote.BadRequestException;
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

    @GetMapping ("/compare")
    public ResponseEntity<?> getProductsById(@RequestParam List<Long> id) {
        if (id.isEmpty()) {
           throw new EmptyListException("Product IDs cannot be empty");
        }
        List<Product> products = productService.getProductsById(id);
        if (products.isEmpty()) {
            throw new NotFoundException("Products not found for the given IDs");
        }
        return ResponseEntity.ok(products);
    }
}
