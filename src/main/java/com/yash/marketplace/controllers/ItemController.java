package com.yash.marketplace.controllers;

import com.yash.marketplace.models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class ItemController {
    private Map<String,Item> items = new HashMap<>();
    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable String id){
        Item item = items.get(id);
        if(item == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return item;

    }

    @GetMapping("/item/all")
    Collection<Item> getAllItem(){
        return items.values();
    }

    @PostMapping("/item/add")
    void addItem(@RequestBody Item newItem){
        newItem.set_id(UUID.randomUUID().toString());
        items.put(newItem.get_id(), newItem);
    }

    @DeleteMapping("/item/{id}")
    public Item deleteItem(@PathVariable String id){
        return items.remove(id);
    }

    @PutMapping("/item/update/{id}")
    public Item updateItem(@PathVariable String id,@RequestBody Item updatedItem){
        Item item = items.get(id);
        // Update fields based on the request
        if (updatedItem.getName() != null) {
            item.setName(updatedItem.getName());
        }
        if (updatedItem.getDescription() != null) {
            item.setDescription(updatedItem.getDescription());
        }
        if (updatedItem.getPrice() != null) {
            item.setPrice(updatedItem.getPrice());
        }
        if (updatedItem.getImgUrl() != null) {
            item.setImgUrl(updatedItem.getImgUrl());
        }
        if (updatedItem.getQuantity() != null) {
            item.setQuantity(updatedItem.getQuantity());
        }
        return item;
    }
}
