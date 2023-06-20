package com.example.todolistspringbootintership.services;

import com.example.todolistspringbootintership.models.Item;
import com.example.todolistspringbootintership.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Iterable<Item> getAllSortedBy(String sortBy) {
        switch (sortBy) {
            case "id":
                return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
            case "update-at":
                return itemRepository.findAll(Sort.by(Sort.Direction.DESC, "timeOfUpdated"));
            case "create-at":
                return itemRepository.findAll(Sort.by(Sort.Direction.DESC, "timeOfCreated"));
            default:
                throw new IllegalArgumentException("Invalid sorting option: " + sortBy);
        }
    }

    public Iterable<Item> searchByIndex(Long searchIndex) {
        // Przykładowa implementacja wyszukiwania po indeksie
        return itemRepository.findAll().stream()
                .filter(item -> item.getId().equals(searchIndex))
                .collect(Collectors.toList());
    }

}
