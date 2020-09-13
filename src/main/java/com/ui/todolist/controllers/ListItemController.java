package com.ui.todolist.controllers;

import com.ui.todolist.entities.ListItem;
import com.ui.todolist.services.ListItemService;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value="/listitem")
public class ListItemController {

    @Autowired
    ListItemService listItemService;

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("listItem_list");
        List<ListItem> listItemList = listItemService.getAllListItems();
        model.addObject("listItemList", listItemList);

        return model;
    }

    @RequestMapping(value="/addListItem/", method=RequestMethod.GET)
    public ModelAndView addListItem() {
        ModelAndView model = new ModelAndView();

        ListItem listItem = new ListItem();
        model.addObject("listItemForm", listItem);
        model.setViewName("listItem_form");

        return model;
    }

    @RequestMapping(value="/updateListItem/{id}", method=RequestMethod.GET)
    public ModelAndView editListItem(@PathVariable long id) {
        ModelAndView model = new ModelAndView();

        ListItem article = listItemService.getListItemById(id);
        model.addObject("listItemForm", article);
        model.setViewName("listItem_form");

        return model;
    }

    @RequestMapping(value="/saveListItem", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("listItemForm") ListItem listItem) {
        listItemService.saveOrUpdate(listItem);

        return new ModelAndView("redirect:/listitem/list");
    }

    @RequestMapping(value="/deleteListItem/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {
        listItemService.deleteListItem(id);

        return new ModelAndView("redirect:/listitem/list");
    }
    /*
    @Autowired
    public ListItemController(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    @GetMapping("/new")
    public String showSignUpForm(ListItem listItem) {
        return "add-listItem";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ListItem listItem = listItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("listItems", listItem);
        return "update-listItem";
    }

    @GetMapping("/delete/{id}")
    public String deleteListItem(@PathVariable("id") long id, Model model) {
        ListItem listItem = listItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        listItemRepository.delete(listItem);
        model.addAttribute("listItems", listItemRepository.findAll());
        return "index";
    }

    @PostMapping("/addListItem")
    public String addListItem(@Valid ListItem listItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-listItem";
        }

        listItemRepository.save(listItem);
        model.addAttribute("listItems", listItemRepository.findAll());

        return "index";
    }

    @PostMapping("/update/{id}")
    public String updateListItem(@PathVariable("id") long id, @Valid ListItem listItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            listItem.setId(id);
            return "update-listItem";
        }

        listItemRepository.save(listItem);
        model.addAttribute("listItems", listItemRepository.findAll());
        return "index";
    }
     */
}
