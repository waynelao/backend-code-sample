package com.usc.handler;

import com.usc.dao.UserDao;
import com.usc.beans.User;
import com.usc.security.SecurityUtils;
import com.usc.service.UserService;
import com.usc.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserDao userDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        final User user = userDao.findByUsername(authentication.getName());
        final String token = jwtUtility.generateToken(user);
        SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK,
                "Login successfully.", token, null);
    }
}
