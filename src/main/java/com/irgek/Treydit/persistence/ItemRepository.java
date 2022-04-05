package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, ItemRepositoryCustom>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {
    Optional<Item> countItemByCategory(Category category);
    Optional<Item> findItemById(Long id);
    Optional<Item> findItemByName(String name);
}
