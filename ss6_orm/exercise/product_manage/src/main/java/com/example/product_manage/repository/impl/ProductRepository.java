package com.example.product_manage.repository.impl;

import com.example.product_manage.model.Product;
import com.example.product_manage.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository

public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> listProductByName(String name) {
        List<Product> products = BaseRepository.entityManager.createNamedQuery("findAllProductWithName", Product.class).setParameter("name", name).getResultList();
        return products;
    }

    @Override
    public void createProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(int id) {
        Product product = findById(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (product != null) {
            BaseRepository.entityManager.remove(product);
        }
        entityTransaction.commit();
    }
}
