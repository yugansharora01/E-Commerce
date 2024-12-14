package com.yash.marketplace.controllers;

import com.yash.marketplace.Repository.ItemRepository;
import com.yash.marketplace.models.Item;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id){
        Optional<Item> item = itemRepository.findById((id));
        if(item.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return item.get();
    }

    @GetMapping("/all")
    List<Item> getAllItem(){
        return itemRepository.findAll();
    }

    @PostMapping("/create")
    void createItem(@RequestBody Item newItem){
        itemRepository.create(newItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id){
        itemRepository.delete(id);
    }

    @PutMapping("/update/{id}")
    public void updateItem(@PathVariable Integer id, @NotNull @RequestBody Item updatedItem){
        itemRepository.update((updatedItem));
    }
}
