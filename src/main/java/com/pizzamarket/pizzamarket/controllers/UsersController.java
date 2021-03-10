package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.services.imp.UserServiceImp;
import com.pizzamarket.pizzamarket.services.mappers.imp.UserMapperImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsersController {

    @Autowired
    private UserService userService;


    /**
     * ПОлучение полного списка пользователей
     * @return
     */
    @GetMapping(EndpointConstants.GET_ALL)
    public List<OutputUserDto> allUsers() {

       return userServiceImp.getAllUsers().stream()
               .map(e -> userMapperImp.toDto(e))
               .collect(Collectors.toList());
    }

    /**
     * Получение пользователя по id
     * @param userId id пользователя
     * @return
     */
    @GetMapping(EndpointConstants.GET_BY_USERID)
    public @ResponseBody
    OutputUserDto getUserById(@PathVariable Long userId) {
        return userMapperImp.toDto(userServiceImp.findById(userId).get());
    }

    /**
     * Получение пользователя по номеру телефона
     * @param phoneNumber номер телефона
     * @return
     */
    @GetMapping(EndpointConstants.GET_BY_PHONENUMBER)
    public @ResponseBody
    OutputUserDto getUserByPhoneNumber(@PathVariable Integer phoneNumber) {
        return userMapperImp.toDto(userServiceImp.findByPhoneNumber(phoneNumber));
    }

    /**
     * Добавление нового пользователя
     * @param inputUserDto Входное дто с информацией о пользователе
     */
    @PutMapping(EndpointConstants.PUT_CREATE)
    public void createUser(@RequestBody InputUserDto inputUserDto) {
        userServiceImp.createUser(inputUserDto);
    }

    //TODO подумать о эксепшенах

}
