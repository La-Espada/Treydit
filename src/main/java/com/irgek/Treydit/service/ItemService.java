package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.Category;
import com.irgek.Treydit.domain.Condition;
import com.irgek.Treydit.domain.Item;
import com.irgek.Treydit.domain.Treyder;
import com.irgek.Treydit.foundation.TemporalValueFactory;
import com.irgek.Treydit.persistence.ItemRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
import com.irgek.Treydit.service.dto.ItemDto;
import com.irgek.Treydit.service.dto.MutateItemCommand;
import com.irgek.Treydit.service.dto.TreyderDto;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private String CANNOT_BE_NULL = "cannot be null!";
    private String CANNOT_BE_EMPTY_OR_BLANK = "cannot be empty or blank!";
    private final TemporalValueFactory temporalValueFactory;

    public Item createItem(MutateItemCommand itemCommand){
        Item newItem = null;
        LocalDateTime created = temporalValueFactory.created_at();

        /*if(name == null){
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
        */
        try{
            var item = itemRepository.findItemByName(itemCommand.getName());
            if(item.isPresent()){
                return item.get();
            }
            newItem = Item.builder()
                    .name(itemCommand.getName())
                    .itemCondition(itemCommand.getItemCondition())
                    .cost(itemCommand.getCost())
                    .category(itemCommand.getCategory())
                    .description(itemCommand.getDescription())
                    .treyder(itemCommand.getTreyder())
                    .created(created)
                    .build();
            return itemRepository.save(newItem);
        }
        catch (PersistenceException pEx){
            throw ServiceException.cannotCreateEntity(newItem,pEx);
        }

    }

    @Transactional
    public Item createItemDto(ItemDto itemDto){
        Item newItem = null;
        LocalDateTime created = temporalValueFactory.created_at();

        try{
            var item = itemRepository.findItemByName(itemDto.name());
            if(item.isPresent()){
                return item.get();
            }
            newItem = Item.builder()
                          .name(itemDto.name())
                          .itemCondition(itemDto.condition())
                          .category(itemDto.category())
                          .cost(itemDto.cost())
                          .description(itemDto.description())
                          .treyder(itemDto.treyder())
                          .created(created)
                          .build();
            return itemRepository.save(newItem);
        }catch(PersistenceException ex){
            throw ServiceException.cannotCreateEntity(newItem,ex);
        }
    }

    public Item replaceItem(Long id, MutateItemCommand itemCommand){
        Optional<Item> entity = itemRepository.findItemByName(itemCommand.getName());
        LocalDateTime replace = temporalValueFactory.replaced_at();
        Item item = null;
        try{
            if(entity.isPresent()){
                item = entity.get();
                item.setName(itemCommand.getName());
                item.setCategory(itemCommand.getCategory());
                item.setItemCondition(itemCommand.getItemCondition());
                item.setCost(itemCommand.getCost());
                item.setDescription(itemCommand.getDescription());
                item.setTreyder(itemCommand.getTreyder());
                item.setUpdated(itemCommand.getUpdated());
            }
            return itemRepository.save(item);
        }catch(PersistenceException ex){
            throw ServiceException.cannotUpdateEntity(item,ex);
        }
    }

    public Item partiallyUpdate(Long id, MutateItemCommand itemCommand){
        Optional<Item> items = itemRepository.findItemById(id);
        LocalDateTime partiallyUpdated = temporalValueFactory.replaced_at();

        if(items.isPresent()){
            Item item = items.get();
            if(itemCommand.getName() != null){
                item.setName(itemCommand.getName());
            }
            if(itemCommand.getItemCondition() != null){
                item.setItemCondition(itemCommand.getItemCondition());
            }
            if(itemCommand.getCategory() != null){
                item.setCategory(itemCommand.getCategory());
            }
           /* if(itemCommand.getCost() != null){
                item.setCost(itemCommand.getCost());
            }

            */
        }
    }

}
