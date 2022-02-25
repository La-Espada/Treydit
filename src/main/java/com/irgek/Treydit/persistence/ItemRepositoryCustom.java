package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemRepositoryCustom {
    Item addItem(Item item);
    Item getByName(String itemName);
    List<Item> getItemsbyTreyder(Treyder treyder);
}
