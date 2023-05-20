package com.usc.dao;

import com.usc.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Integer> {
    Country findByCode(String code);

}
