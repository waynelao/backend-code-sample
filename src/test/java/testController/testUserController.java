package testController;

import com.usc.beans.User;
import com.usc.controller.UserController;
import com.usc.dao.UserDao;
import com.usc.service.UserService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class testUserController {

    @InjectMocks
    UserController userController;

    @Mock
    UserDao userDao;

    @Mock
    UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @WithMockUser(username="usr", roles={"ROLE_ADMIN"})
    public void getusersTest() {
        User user1 = new User(1, "usr1", "usr1", null);
        User user2 = new User(2, "usr2", "usr2", null);
        User user3 = new User(3, "usr3", "usr3", null);
        List<User> list = Arrays.asList(new User[]{user1, user2, user3});
        Mockito.when(userDao.findAll()).thenReturn(list);
        assertEquals(3, userController.getusers().size());
        Mockito.verify(userDao, Mockito.times(1)).findAll();
    }

}
