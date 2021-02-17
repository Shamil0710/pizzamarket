package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("user/all")
    public List<User> allUsers() {

       return userServiceImp.getAllUsers();
    }
}
