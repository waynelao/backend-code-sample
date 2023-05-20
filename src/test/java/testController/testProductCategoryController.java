package testController;

import com.usc.beans.ProductCategory;
import com.usc.controller.ProductCategoryController;
import com.usc.dao.ProductCategoryDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class testProductCategoryController {
    @InjectMocks
    ProductCategoryController productCategoryController;

    @Mock
    ProductCategoryDao productCategoryDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductCategoriesTest() {
        ProductCategory book = new ProductCategory(1L, "BOOKS");
        ProductCategory video = new ProductCategory(1L, "VIDEOS");
        List<ProductCategory> list = Arrays.asList(book, video);
        Mockito.when(productCategoryDao.findAll()).thenReturn(list);
        Assert.assertEquals(2, productCategoryController.getProductCategories().size());
        Mockito.verify(productCategoryDao, Mockito.times(1)).findAll();
    }

}
