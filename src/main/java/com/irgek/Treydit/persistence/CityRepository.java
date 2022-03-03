package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository <City, CityRepositoryCustom>, QuerydslPredicateExecutor<City>, CityRepositoryCustom {
    Optional<City> findCityByName(String name);
    Optional<City> findCityById(Long id);
}
