package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProductByName(String name);

    void createProduct(Product product);

    Product findById(int id);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
