package com.example.RESTapi.repository;

import com.example.RESTapi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
