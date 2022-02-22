package com.irgek.persistence;

import com.irgek.domain.Category;
import com.irgek.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, ItemRepositoryCustom>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {
    Optional<Item> countItemByCategory(Category category);
}
