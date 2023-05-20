package com.usc.dao;

import com.usc.beans.Order;
import com.usc.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OrderDao extends JpaRepository<Order, Integer> {
    Set<Order> findByUser(User user);

}
