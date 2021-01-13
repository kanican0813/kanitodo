package com.example.kanitodo.application.controller;

import com.example.kanitodo.domain.repository.ITodoItemRepository;
import com.example.kanitodo.infrastructure.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TodoController {

    @Autowired
    ITodoItemRepository iTodoItemRepository;

//    @Autowired
//    public TodoController(ITodoItemRepository iTodoItemRepository) {
//        this.iTodoItemRepository = iTodoItemRepository;
//    }

    @RequestMapping
    public String index(@ModelAttribute TodoItemForm todoItemForm, @RequestParam("isDone") Optional<Boolean> isDone) {
        todoItemForm.setDone(isDone.isPresent() ? isDone.get() : false);
        todoItemForm.setTodoItems(this.iTodoItemRepository.findByDoneOrderByTitleAsc(todoItemForm.isDone()));
        return "index";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String done(@RequestParam("id") long id) {
        TodoItem item = this.iTodoItemRepository.findById(id);
        item.setDone(true);
        this.iTodoItemRepository.save(item);
        return "redirect:/?isDone=false";
    }

    @RequestMapping(value = "/restore", method = RequestMethod.POST)
    public String restore(@RequestParam("id") long id) {
        TodoItem item = this.iTodoItemRepository.findById(id);
        item.setDone(false);
        this.iTodoItemRepository.save(item);
        return "redirect:/?isDone=true";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newItem(TodoItem item) {
        item.setDone(false);
        this.iTodoItemRepository.save(item);
        return "redirect:/";
    }
}
