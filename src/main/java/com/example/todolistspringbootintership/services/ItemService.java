package com.example.todolistspringbootintership.services;

import com.example.todolistspringbootintership.models.Item;
import com.example.todolistspringbootintership.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Item save(Item item) {
        if (item.getId() == null) {
            item.setTimeOfCreated(LocalDateTime.now());
        }
        item.setTimeOfUpdated(LocalDateTime.now());
        return itemRepository.save(item);
    }

    public void delete(Item Item) {
        itemRepository.delete(Item);
    }
}
