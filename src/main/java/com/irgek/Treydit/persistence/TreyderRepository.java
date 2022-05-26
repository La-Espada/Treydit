package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TreyderRepository extends JpaRepository<Treyder, Long> {
    Treyder findTreyderByUsername(String username);
    Treyder findTreyderById (Long id);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<Treyder> findTreyderByEmail(String email);

}
