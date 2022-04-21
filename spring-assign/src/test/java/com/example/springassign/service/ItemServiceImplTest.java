package com.example.springassign.service;

import com.example.springassign.entity.Item;
import com.example.springassign.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    private ItemServiceImpl itemServiceImpl;

    @BeforeEach
    void setUp() {
        this.itemServiceImpl = new ItemServiceImpl(itemRepository);
    }

    @Test
    void getItems() {

        itemServiceImpl.getItems();
        verify(itemRepository).findAll();
    }

    @Test
    void saveItem() {

        Item item = new Item();
        item.setId(1);
        item.setItemName("Cycle");
        item.setDeleted(true);
        item.setItemPrice(4500);
        item.setSellerId(2);

        Mockito.when(itemRepository.save(item)).thenReturn(item);
        assertThat(itemServiceImpl.saveItem(item)).isEqualTo(item);

    }

    @Test
    void getItem() {

        Item item = new Item();
        item.setId(1);
        item.setItemName("Cycle");
        item.setDeleted(false);
        item.setItemPrice(4500);
        item.setSellerId(2);

        Mockito.when(itemRepository.getById(1)).thenReturn(item);
        assertThat(itemServiceImpl.getItem(1)).isEqualTo(item);

    }

    @Test
    void deleteItem() {

        Item item = new Item();
        item.setId(1);
        item.setItemName("Cycle");
        item.setDeleted(false);
        item.setItemPrice(4500);
        item.setSellerId(2);


        Mockito.when(itemRepository.existsById(item.getId())).thenReturn(false);
        assertFalse(itemRepository.existsById(item.getId()));

    }

}