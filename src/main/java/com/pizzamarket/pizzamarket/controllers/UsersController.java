package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.services.imp.UserServiceImp;
import com.pizzamarket.pizzamarket.services.mappers.imp.UserMapperImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsersController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private UserMapperImp userMapperImp;

    @GetMapping("user/all")
    public List<OutputUserDto> allUsers() {

       return userServiceImp.getAllUsers().stream()
               .map(e -> userMapperImp.toDto(e))
               .collect(Collectors.toList());
    }

    @GetMapping("user/{userId}")
    public @ResponseBody
    OutputUserDto getUserById(@PathVariable Long userId) {
        return userMapperImp.toDto(userServiceImp.findById(userId).get());
    }

    @GetMapping("user/{phoneNumber}")
    public @ResponseBody
    OutputUserDto getUserByPhoneNumber(@PathVariable Integer phoneNumber) {
        return userMapperImp.toDto(userServiceImp.findByPhoneNumber(phoneNumber));
    }

    @PutMapping("user/create")
    public void createUser(@RequestBody InputUserDto inputUserDto) {
        userServiceImp.createUser(inputUserDto);
    }

    //TODO подумать о эксепшенах

}
