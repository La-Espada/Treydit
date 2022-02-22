package com.irgek.persistence;

import com.irgek.domain.Item;
import com.irgek.domain.Treyder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemRepositoryCustom {
    Item addItem(Item item);
    Item getByName(String itemName);
    List<Item> getItemsbyTreyder(Treyder treyder);
}
