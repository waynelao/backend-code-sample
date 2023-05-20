package com.usc.controller;

import com.usc.beans.User;
import com.usc.dao.UserDao;
import com.usc.service.UserService;
import com.usc.http.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()   // rest API request (default json response, not need responsebody)
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<User> getusers() {
        return userDao.findAll();
    }

    @PostMapping
    public Response addUser(@RequestBody User user) {  // json
        return userService.register(user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping
    public Response changeUser(@RequestBody User user, Authentication authentication) {
        return userService.changePassword(user, authentication);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/isadmin")
    public Map<String, Boolean> isAdmin(Authentication authentication) {
        boolean isAdmin = userService.isAdmin(authentication.getAuthorities());
        Map<String, Boolean> response = new HashMap<>();
        response.put("isAdmin", isAdmin);
        return response;
    }

}
