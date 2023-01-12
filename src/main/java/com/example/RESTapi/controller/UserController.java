package com.example.RESTapi.controller;

import com.example.RESTapi.entity.UserEntity;
import com.example.RESTapi.exception.UserAlreadyExistExeption;
import com.example.RESTapi.exception.UserNotFoundException;
import com.example.RESTapi.repository.UserRepo;
import com.example.RESTapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {

            userService.registration(user);
                return ResponseEntity.ok("Пользователь сохранен");
            } catch (UserAlreadyExistExeption ex) {

            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException ex) {

            return ResponseEntity.badRequest().body(ex.getMessage());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id)
    {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
