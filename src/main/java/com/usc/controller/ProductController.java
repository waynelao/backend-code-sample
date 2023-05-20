package com.usc.controller;

import com.usc.beans.Product;
import com.usc.dao.ProductDao;
import com.usc.http.Response;
import com.usc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productDao.findAll();
    }

    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public Response addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping("/{id}")
    public Response updateProduct(@PathVariable Long id, String description, double unitPrice) {
        return productService.updateProduct(id, description, unitPrice);
    }

    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @DeleteMapping("/{id}")
    public Response deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
