package com.usc.controller;

import com.usc.beans.Product;
import com.usc.beans.ProductCategory;
import com.usc.dao.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/product-category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @GetMapping
    public List<ProductCategory> getProductCategories() {
        return productCategoryDao.findAll();
    }

    @GetMapping("/{id}")
    public Set<Product> getProductCategory(@PathVariable Long id) {
        return productCategoryDao.findById(id).get().getProducts();
    }
}
