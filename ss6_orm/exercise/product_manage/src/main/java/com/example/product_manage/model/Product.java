package com.example.product_manage.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NamedQuery(
        name = "findAllProductWithName",
        query = "select p from Product p where name like concat('%', :name, '%')"
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name_product", columnDefinition = "VARCHAR(50)")
    private String name;
    @Column(name = "price", columnDefinition = "INT")
    private Integer price;
    @Column(name = "describe_product", columnDefinition = "TEXT")
    private String describe;
    @Column(name = "producer")
    private String producer;

    public Product() {
    }

    public Product(Integer id, String name, Integer price, String describe, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
