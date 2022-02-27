package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.Category;
import com.irgek.Treydit.domain.Condition;
import com.irgek.Treydit.domain.Item;
import com.irgek.Treydit.domain.Treyder;
import com.irgek.Treydit.persistence.ItemRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private String CANNOT_BE_NULL = "cannot be null!";
    private String CANNOT_BE_EMPTY_OR_BLANK = "cannot be empty or blank!";

    public Item createItem(String name, double cost, String description, Condition condition, Category category, Treyder treyder){
        Item newItem = null;

        if(name == null){
            throw new IllegalArgumentException("Name " + CANNOT_BE_NULL);
        }
        else if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        else if(description == null){
            throw new IllegalArgumentException("description " + CANNOT_BE_NULL);
        }
        else if (description.isBlank() || description.isEmpty()) {
            throw new IllegalArgumentException("description " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        else if(condition == null){
            throw new IllegalArgumentException("condition " + CANNOT_BE_NULL);
        }
        else if(category == null){
            throw new IllegalArgumentException("category " + CANNOT_BE_NULL);
        }
        else if(treyder == null){
            throw new IllegalArgumentException("treyder " + CANNOT_BE_NULL);
        }
        try{
            var item = itemRepository.findItemByName(name);
            if(item.isPresent()){
                return item.get();
            }
            newItem = Item.builder()
                    .name(name)
                    .itemCondition(condition)
                    .cost(cost)
                    .category(category)
                    .description(description)
                    .treyder(treyder)
                    .build();
            return itemRepository.save(newItem);
        }
        catch (PersistenceException pEx){
            throw ServiceException.cannotCreateEntity(newItem,pEx);
        }

    }

}
