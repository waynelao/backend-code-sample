package com.usc.dao;

import com.usc.beans.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Long> {

    Optional<ProductCategory> findById(Long id);
}
