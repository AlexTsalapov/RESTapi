package com.example.RESTapi.model;

import com.example.RESTapi.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;
    public static Todo toModel(TodoEntity entity)
    {
        Todo model=new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }
}
