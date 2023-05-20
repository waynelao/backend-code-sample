package testController;

import com.usc.controller.AuthController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class testAuthController {
    @InjectMocks
    AuthController authController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void checkLoginTest() {
        Authentication authentication = Mockito.mock(Authentication.class);
        // when(authentication.).thenReturn(true);
        assertTrue(authController.checkLogin(authentication).isSuccess());
    }

}
