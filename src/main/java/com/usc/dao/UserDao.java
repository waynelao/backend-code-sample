package com.usc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usc.beans.User;

@Repository  // what this annotation means
public interface UserDao extends JpaRepository<User, Integer> {
    // data access object
    User findByUsername(String username);


}
