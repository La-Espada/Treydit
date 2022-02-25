package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreyderRepository extends JpaRepository<Treyder,TreyderRepositoryCustom>, QuerydslPredicateExecutor<Treyder>,TreyderRepositoryCustom {
    Optional<Treyder> findTreyderByUsername(String username);
}
