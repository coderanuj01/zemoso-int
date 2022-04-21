package com.example.springassign.service;

import com.example.springassign.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    Item saveItem(Item theItem);

    Item getItem(int theId);

    void deleteItem(int theId);

    Item setDeleted(int theId);

}
