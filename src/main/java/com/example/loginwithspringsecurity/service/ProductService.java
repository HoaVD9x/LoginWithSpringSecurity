package com.example.loginwithspringsecurity.service;

import com.example.loginwithspringsecurity.model.Products;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Products> listProduct ();

    Products product (String productCode);
}
