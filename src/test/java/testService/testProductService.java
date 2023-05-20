package testService;

import com.usc.beans.Product;
import com.usc.dao.ProductDao;
import com.usc.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class testProductService {
    @InjectMocks
    ProductService productService;

    @Mock
    ProductDao productDao;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void deleteProductTest() {
        Product product = new Product();
        when(productDao.findById(1L)).thenReturn(Optional.of(product));
        when(productDao.findById(10L)).thenReturn(null);

        assertTrue(productService.deleteProduct(1L).isSuccess());
        assertFalse(productService.deleteProduct(10L).isSuccess());
        verify(productDao, times(1)).findById(1L);
        verify(productDao, times(1)).findById(10L);
    }

    @Test
    public void updateProductTest() {
        Product product = new Product();
        when(productDao.findById(1L)).thenReturn(Optional.of(product));
        assertTrue(productService.deleteProduct(1L).isSuccess());
        verify(productDao, times(1)).findById(1L);
    }


}
