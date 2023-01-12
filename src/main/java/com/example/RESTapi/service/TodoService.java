package com.example.RESTapi.service;

import com.example.RESTapi.entity.TodoEntity;
import com.example.RESTapi.entity.UserEntity;
import com.example.RESTapi.model.Todo;
import com.example.RESTapi.repository.TodoRepo;
import com.example.RESTapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;
    public Todo createToDo(TodoEntity todo, Long userId)
    {
        UserEntity user=userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }
    public Todo completeToDo(Long id)
    {
        TodoEntity todo=todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));

    }
}
