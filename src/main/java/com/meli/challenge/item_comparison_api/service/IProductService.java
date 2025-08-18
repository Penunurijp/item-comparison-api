package com.meli.challenge.item_comparison_api.service;

import com.meli.challenge.item_comparison_api.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getProductsById(List<Long> ids);
}
