package testController;

import com.usc.controller.CheckoutController;
import com.usc.dto.PurchaseDTO;
import com.usc.dto.PurchaseResponseDTO;
import com.usc.service.CheckoutService;
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
import org.springframework.security.core.Authentication;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class testCheckoutController {
    @InjectMocks
    CheckoutController checkoutController;

    @Mock
    CheckoutService checkoutService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void placeOrderTest() {
        Authentication authentication = Mockito.mock(Authentication.class);
        PurchaseDTO purchase = new PurchaseDTO(null, null, null, null, new HashSet<>());
        PurchaseResponseDTO response = new PurchaseResponseDTO("new order");
        Mockito.when(checkoutService.placeOrder(purchase, authentication)).thenReturn(response);
        Assert.assertEquals("new order", checkoutController.placeOrder(purchase, authentication).getOrderTrackingNumber());
        Mockito.verify(checkoutService, Mockito.times(1)).placeOrder(purchase, authentication);
    }
}
