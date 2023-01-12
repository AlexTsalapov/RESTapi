package com.example.RESTapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<TodoEntity> todos;
}
