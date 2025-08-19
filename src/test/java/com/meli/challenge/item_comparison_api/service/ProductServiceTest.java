package com.meli.challenge.item_comparison_api.service;

import com.meli.challenge.item_comparison_api.exception.EmptyListException;
import com.meli.challenge.item_comparison_api.exception.NotFoundException;
import com.meli.challenge.item_comparison_api.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void getProductsByIdTest() {
        List<Long> productListId= new ArrayList<>();
        productListId.add(1L);
        productListId.add(2L);

        List<Product> products = productService.getProductsById(productListId);

        assertEquals(2, products.size());
        assertEquals(1, products.get(0).getId());
        assertEquals("Product 1", products.get(0).getName());
        assertEquals(2, products.get(1).getId());
        assertEquals("Product 2", products.get(1).getName());
    }

    @Test
    void getProductsById_withEmptyList_shouldThrowException() {
        List<Long> productListId = new ArrayList<>();

        List<Product> products = productService.getProductsById(productListId);
        assertTrue(products.isEmpty());
        assertThrows(EmptyListException.class, () -> {
            if (products.isEmpty()) {
                throw new EmptyListException("Product IDs cannot be empty");
            }
        });
    }

    @Test
    void getProductsById_notFound_shouldThrowException() {
        List<Long> productListId = new ArrayList<>();

        List<Product> products = productService.getProductsById(productListId);
        assertTrue(products.isEmpty());
        assertThrows(NotFoundException.class, () -> {
            if (products.isEmpty()) {
                throw new NotFoundException("Product IDs cannot be empty");
            }
        });
    }
}