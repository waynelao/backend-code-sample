package testController;

import com.usc.beans.Order;
import com.usc.controller.OrderHistoryController;
import com.usc.dao.OrderDao;
import org.hibernate.validator.constraints.Mod10Check;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class testOrderHistoryController {

    @InjectMocks
    OrderHistoryController orderHistoryController;

    @Mock
    OrderDao orderDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @WithMockUser(username = "usr", roles = {"ROLE_ADMIN"})
    public void getordersTest() {
        Order order1 = new Order(1, "1", 1, 50.99, null, null, null, null,
                null, null, null, null);
        Order order2 = new Order(2, "2", 2, 60.99, null, null, null, null,
                null, null, null, null);
        Order order3 = new Order(3, "3", 3, 70.99, null, null, null, null,
                null, null, null, null);
        List<Order> list = Arrays.asList(new Order[]{order1, order2, order3});
        Mockito.when(orderDao.findAll()).thenReturn(list);
        Assert.assertEquals(3, orderHistoryController.getorders().size());
        Mockito.verify(orderDao, Mockito.times(1)).findAll();

    }
}
