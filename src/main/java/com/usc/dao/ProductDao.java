package com.usc.dao;

import com.usc.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
    void deleteById(Long id);
}
