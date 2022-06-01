package com.irgek.Treydit.service;


import com.irgek.Treydit.domain.Item;
import com.irgek.Treydit.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public L
}
