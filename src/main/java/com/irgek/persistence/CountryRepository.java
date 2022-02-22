package com.irgek.persistence;

import com.irgek.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,CountryRepositoryCustom>, QuerydslPredicateExecutor<Country>, CountryRepositoryCustom {
    Optional<Country> findCountryByName(String name);
}
