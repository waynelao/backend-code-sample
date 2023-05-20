package com.usc.handler;

import com.usc.security.SecurityUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    // spring boot session key table
    // j session id / JWT token
    // login only look up key
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        SecurityUtils.sendResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Not authorized resources", null,
                accessDeniedException);
    }
}
