package com.rkProductManager.productManager.service;

import com.rkProductManager.productManager.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {

    Integer saveProduct(Product p);
    void updateProduct(Product p);
    void deleteProduct(Integer id);
    Product getOneProduct(Integer id);
    List<Product> getAllProduct();

    void updateproductCodeById(String code, Integer id);

}
