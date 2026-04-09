package com.to_do_list.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.to_do_list.entity.ToDo;
import com.to_do_list.service.ToDoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    List<ToDo> create(@RequestBody @Valid ToDo toDo) {
        return toDoService.create(toDo);
    }

    @GetMapping
    List<ToDo> list() {
        return toDoService.list();
    }

    @PutMapping
    List<ToDo> update(@RequestBody ToDo toDo) {
        return toDoService.update(toDo);
    }

    @DeleteMapping("{id}")
    List<ToDo> delete(@PathVariable("id") Long id) {
        return toDoService.delete(id);
    }
}
