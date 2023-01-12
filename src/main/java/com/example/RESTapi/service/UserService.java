package com.example.RESTapi.service;

import com.example.RESTapi.entity.UserEntity;
import com.example.RESTapi.exception.UserAlreadyExistExeption;
import com.example.RESTapi.exception.UserNotFoundException;
import com.example.RESTapi.model.User;
import com.example.RESTapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistExeption {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistExeption("Пользователь уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user=userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }
    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
