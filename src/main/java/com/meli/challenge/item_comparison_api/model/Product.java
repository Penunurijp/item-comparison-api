package com.meli.challenge.item_comparison_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private double rating;
    private String specifications;
}
