package com.example.todolistspringbootintership.services;

import com.example.todolistspringbootintership.models.Item;
import com.example.todolistspringbootintership.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ItemService
{
    @Autowired
    private ItemRepository itemRepository;

    public Optional<Item> getById(Long id) {
        return itemRepository.findById(id);
    }

    public Iterable<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item save(Item Item) {
        if (Item.getId() == null) {
            Item.setTimeOfCreated(Instant.now());
        }
        Item.setTimeOfUpdated(Instant.now());
        return itemRepository.save(Item);
    }

    public void delete(Item Item) {
        itemRepository.delete(Item);
    }
}
