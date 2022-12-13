package com.example.loginwithspringsecurity.repository;

import com.example.loginwithspringsecurity.model.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttemptsRepository extends JpaRepository<Attempts, Integer> {

    Optional<Attempts> findByEmail(String email);
}
