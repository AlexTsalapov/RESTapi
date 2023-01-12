package com.example.RESTapi.controller;

import com.example.RESTapi.entity.TodoEntity;

import com.example.RESTapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createToDo(todo,userId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.completeToDo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}