package com.example.todolistspringbootintership.controllers;

import com.example.todolistspringbootintership.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @Autowired
    private ItemService itemService;

    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "redirect:/home/id";
    }

    @GetMapping("/home/{sortBy}")
    public ModelAndView homeSorted(@PathVariable("sortBy") String sortBy) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("items", itemService.getAllSortedBy(sortBy));
        return modelAndView;
    }

    @GetMapping("/home/search")
    public ModelAndView searchByIndex(@RequestParam("searchIndex") Long searchIndex) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("items", itemService.searchByIndex(searchIndex));
        return modelAndView;
    }

}
