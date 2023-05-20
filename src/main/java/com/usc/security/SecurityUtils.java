package com.usc.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usc.http.Response;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecurityUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse response, int status, String message, String token, Exception exception)
            throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        if (token == null) {
            writer.write(mapper.writeValueAsString(new Response(exception == null ? true : false, status, message)));
        } else {
            writer.write(mapper.writeValueAsString(new Response(exception == null ? true : false, status, message, token)));
        }
        response.setStatus(status);
        writer.flush();
        writer.close();

    }
}
