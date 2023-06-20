package com.example.todolistspringbootintership.controllers;

import com.example.todolistspringbootintership.models.Item;
import com.example.todolistspringbootintership.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController
{
    @Autowired
    private ItemService itemService;

    @GetMapping("/create-todo")
    public String createForm(Item item) {
        return "createTodo";
    }

    @PostMapping("/todo")
    public String createTodo(@Valid Item item, BindingResult result, Model model) {
        Item newItem = new Item();
        newItem.setDescription(item.getDescription());
        newItem.setIsReady(item.getIsReady());
        itemService.save(newItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id, Model model) {
        Item item = getItemById(id);

        itemService.delete(item);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String goToUpdateItem(@PathVariable("id") Long id, Model model) {
        Item item = getItemById(id);

        model.addAttribute("todo", item);
        return "editItem";
    }

    @PostMapping("/todo/{id}")
    public String updateItem(@PathVariable("id") Long id, @Valid Item item, BindingResult result, Model model) {
        Item newItem = getItemById(id);

        newItem.setIsReady(item.getIsReady());
        newItem.setDescription(item.getDescription());

        itemService.save(item);
        return "redirect:/";
    }

    public Item getItemById(Long id) {
        return itemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item does not exist"));
    }
}
