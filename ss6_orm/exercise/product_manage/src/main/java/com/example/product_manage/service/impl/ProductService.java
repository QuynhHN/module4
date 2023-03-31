package com.example.product_manage.service.impl;

import com.example.product_manage.model.Product;
import com.example.product_manage.repository.IProductRepository;
import com.example.product_manage.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> listProductByName(String name) {
        return iProductRepository.listProductByName(name);
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        iProductRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }
}
