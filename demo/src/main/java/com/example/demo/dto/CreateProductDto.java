package com.example.demo.dto;

import com.example.demo.models.Product;

public record CreateProductDto(
        String name,
        double price
) {

    public Product toProduct(){
        return new Product(null, this.name, this.price);
    }

}
