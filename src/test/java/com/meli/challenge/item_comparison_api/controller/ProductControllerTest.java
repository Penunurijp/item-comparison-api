package com.meli.challenge.item_comparison_api.controller;

import com.meli.challenge.item_comparison_api.model.Product;
import com.meli.challenge.item_comparison_api.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void getProductsById() throws Exception {
        List<Long> productListId= new ArrayList<>();
        productListId.add(1L);
        productListId.add(2L);

        when(productService.getProductsById(productListId)).thenReturn(List.of(
                new Product(1L, "Product 1", "Description 1", 100.0, "image1.jpg", 4.5, "specifications1"),
                new Product(2L, "Product 2", "Description 2", 200.0, "image2.jpg", 4.0, "specifications2")
        ));

        mockMvc.perform(get("http://localhost:8080/products/compare")
                        .param("id", "1", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Product 1"));
    }
}