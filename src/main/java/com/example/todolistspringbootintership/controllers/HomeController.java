package com.example.todolistspringbootintership.controllers;

import com.example.todolistspringbootintership.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @Autowired
    private ItemService itemService;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("items", itemService.getAll());
        return modelAndView;
    }
}
