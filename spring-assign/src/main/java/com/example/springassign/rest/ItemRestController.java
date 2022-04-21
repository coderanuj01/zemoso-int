package com.example.springassign.rest;

import com.example.springassign.entity.Item;
import com.example.springassign.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemService itemService;

    // mapping for get all items... get ... /items
    @GetMapping("/item")
    public String getItems(Model theModel){

        List<Item> itemsList = itemService.getItems();

        List<Item> itemListWithBool = new ArrayList<>();

        for(Item tempItem : itemsList){
            if(tempItem.isDeleted()){
                itemListWithBool.add(tempItem);
            }
        }

        theModel.addAttribute("itemModel",itemListWithBool);

        return "items-list";
    }

    // get mapping to show item adding form
    @GetMapping("/showFormToAddItem")
    public String showFormToAddItem(Model theModel){

        //  create model attribute to bind form data
        Item theItem = new Item();

        theModel.addAttribute("item",theItem);

        return "item-adding-form";
    }

    // mapping to add new item .... post ... /item
    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("item") Item theItem){
        // also just in the case pass an id in json.. set id to 0
        // this is a force to save new item ... instead of update
        itemService.saveItem(theItem);

        return "redirect:/api/item";
    }

    // mapping to update item .... put ... /item
    @PutMapping("/item")
    public String updateItem(@RequestBody Item theItem){
        theItem.setDeleted(false);

        itemService.saveItem(theItem);

        return "redirect:/api/item";
    }

    // mapping to delete item... delete ... /item
    @DeleteMapping("/item/{itemId}")
    public String deleteItem(@PathVariable int itemId){

        Item tempItem = itemService.getItem(itemId);

        if(tempItem == null){
            // throw new CustomerNotFoundException("item id not found "+ itemId);
        }

        itemService.deleteItem(itemId);

        return "redirect:/api/item";
    }

}
