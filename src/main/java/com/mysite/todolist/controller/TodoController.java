package com.mysite.todolist.controller;

import com.mysite.todolist.model.Todo;
import com.mysite.todolist.repository.TodoRepository;
import com.mysite.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping({"","/"})
    public String showTodoList(Model model) {
        List<Todo> todos = todoService.getTodoList();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String content) {
        todoService.todoCreate(content);
        return "redirect:/todo";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        todoService.todoDelete(id);
        return "redirect:/todo";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestParam boolean completed) {
        todoService.todoUpdate(id, completed);
        return "redirect:/todo";
    }

}
