package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Laptop", 25000, "Gaming", "Dell"));
        productList.add(new Product(2, "Laptop", 20000, "Window 11", "Acer"));
        productList.add(new Product(3, "Laptop", 15000, "Window 10", "Lenovo"));
    }

    @Override
    public List<Product> listProductByName(String name) {
        if (name == null) {
            return productList;
        }
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateProduct(int id,Product product) {
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getId().equals(id)) {
//                productList.set(i, product);
//            }
//        }
        for (Product value : productList) {
            if (product.getId() == value.getId()) {
                value.setName(product.getName());
                value.setPrice(product.getPrice());
                value.setDescribe(product.getDescribe());
                value.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(findById(id));
    }
}
