package com.example.loginwithspringsecurity.service;

import com.example.loginwithspringsecurity.model.Products;
import com.example.loginwithspringsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceIplm implements ProductService{

    @Autowired
    ProductRepository repository;
    @Override
    public List<Products> listProduct() {
        return repository.findAll();
    }

    public Products product (String productCode) {
        return repository.getProductsByProductCode(productCode);
    }
}
