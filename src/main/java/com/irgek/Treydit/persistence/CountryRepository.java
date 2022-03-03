package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,CountryRepositoryCustom>, QuerydslPredicateExecutor<Country>, CountryRepositoryCustom {
    Optional<Country> findCountryByName(String name);
    Country findCountryById(Long id);
}
