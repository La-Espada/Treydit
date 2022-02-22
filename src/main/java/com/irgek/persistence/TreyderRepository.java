package com.irgek.persistence;

import com.irgek.domain.Treyder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreyderRepository extends JpaRepository<Treyder,TreyderRepositoryCustom>, QuerydslPredicateExecutor<Treyder>,TreyderRepositoryCustom {
    Optional<Treyder> findTreyderByUsername(String username);
}
