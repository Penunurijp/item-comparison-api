package com.meli.challenge.item_comparison_api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.challenge.item_comparison_api.model.Product;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private final Map<Long, Product> products;

    public ProductService() {
        Map<Long, Product> tempProducts = new java.util.HashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream("products.json");
            List<Product> productList = mapper.readValue(is, new TypeReference<List<Product>>() {});
            for (Product p : productList) {
                tempProducts.put(p.getId(), p);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load products from JSON file", e);
        }
        this.products = tempProducts;
    }

    @Override
    public List<Product> getProductsById(List<Long> ids) {
        List<Product> productList = new ArrayList<Product>();

        for (Long id : ids) {
            if (products.get(id) != null) {
                productList.add(products.get(id));
            }
        }
        return productList;
    }
}
