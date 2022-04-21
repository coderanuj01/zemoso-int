package com.example.springassign.service;

import com.example.springassign.entity.Item;
import com.example.springassign.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    // injecting item DAO
    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public Item saveItem(Item theItem) {
        itemRepository.save(theItem);
        return theItem;
    }

    @Override
    @Transactional
    public Item getItem(int theId) {
        return itemRepository.getById(theId);
    }

    @Override
    @Transactional
    public void deleteItem(int theId) {
        Item theItem = itemRepository.getById(theId);

        itemRepository.delete(theItem);
    }

    @Override
    @Transactional
    public Item setDeleted(int theId) {
        Item theItem = itemRepository.getById(theId);
        theItem.setDeleted(false);
        itemRepository.save(theItem);
        return theItem;
    }
}
