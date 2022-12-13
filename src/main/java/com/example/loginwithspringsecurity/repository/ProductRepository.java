package com.example.loginwithspringsecurity.repository;

import com.example.loginwithspringsecurity.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Products, String> {

}
