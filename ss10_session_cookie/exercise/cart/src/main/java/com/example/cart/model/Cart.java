package com.example.cart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> map = new HashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Product, Integer> map) {
        this.map = map;
    }
    //    Phương thức checkIntemInCart() để kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product,Integer> entry : map.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product,Integer> selectItemInCart(Product product){
        for (Map.Entry<Product,Integer> entry : map.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }
    //    Phương thức addProduct() được sử dụng để thêm sản phẩm vào trong giỏ hàng.
    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            map.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            map.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void decreaseProduct(Product product){
        if (!checkItemInCart(product)){
            map.put(product,1);
        } else if (map.get(product)==0) {
            map.remove(product);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() - 1;
            map.replace(itemEntry.getKey(),newQuantity);
        }
    }
    //    Phương thức countProductQuantity() dùng để đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }
    //    Phương thức countItemQuantity() để đếm số lượng sản phẩm có trong giỏ hàng.
    public Integer countItemQuantity(){
        return map.size();
    }
    //Phương thức countTotalPayment() dùng để tính tổng số tiền cần phải thanh toán.
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
