package com.example.RESTapi.repository;

import com.example.RESTapi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
