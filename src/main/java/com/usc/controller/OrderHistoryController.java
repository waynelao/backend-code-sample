package com.usc.controller;

import com.usc.beans.Order;
import com.usc.beans.User;
import com.usc.dao.OrderDao;
import com.usc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order-history")
public class OrderHistoryController {

    @Autowired
    UserDao userDao;

    @Autowired
    OrderDao orderDao;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<Order> getorders() {
        return orderDao.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user")
    public Set<Order> getOrderByUser(Authentication authentication) {
        User user = userDao.findByUsername(authentication.getName());
        return orderDao.findByUser(user);
    }

}
