package testController;

import com.usc.beans.Product;
import com.usc.controller.ProductController;
import com.usc.dao.ProductDao;
import org.hibernate.validator.constraints.ModCheck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class testProductController {
    @InjectMocks
    ProductController productController;

    @Mock
    ProductDao productDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductsTest() {
        Product product1 = new Product(1L, null, "book1", "learn code", "great book"
                , 10.99, "/image.jpg");
        Product product2 = new Product(2L, null, "book2", "learn java", "great book"
                , 20.99, "/image.jpg");
        Product product3 = new Product(3L, null, "book3", "learn python", "great book"
                , 30.99, "/image.jpg");
        List<Product> list = Arrays.asList(new Product[]{product1, product2, product3});
        Mockito.when(productDao.findAll()).thenReturn(list);
        Assert.assertEquals(3, productController.getProducts().size());
        Mockito.verify(productDao, Mockito.times(1)).findAll();

    }
}
