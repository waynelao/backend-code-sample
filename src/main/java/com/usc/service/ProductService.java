package com.usc.service;
import com.usc.beans.Product;
import com.usc.beans.ProductCategory;
import com.usc.dao.ProductCategoryDao;
import com.usc.http.Response;

import com.usc.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductCategoryDao productCategoryDao;

    public Response addProduct(Product product) {
        productDao.save(product);
        return new Response((true));
    }

    public Response deleteProduct(Long id) {
        if (productDao.findById(id) != null) {
            productDao.deleteById(id);
            return new Response(true);
        } else {
            return new Response(false, "Product is not found!");
        }
    }

    public Response updateProduct(Long id, String description, double unitPrice) {
        Product product = productDao.findById(id).get();
        product.setDescription(description);
        product.setUnitPrice(unitPrice);
        productDao.save(product);
        return new Response(true);
    }

}
