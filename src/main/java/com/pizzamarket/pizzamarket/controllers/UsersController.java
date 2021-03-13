package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Контролер для доступа к пользователям
 */
@RestController(value = EndpointConstants.USER)
public class UsersController {

    @Autowired
    private UserService userService;


    /**
     * ПОлучение полного списка пользователей
     * @return
     */
    @GetMapping(EndpointConstants.GET_ALL)
    public List<OutputUserDto> allUsers() {
       return userService.findAll();
    }

    /**
     * Получение пользователя по id
     * @param userId id пользователя
     * @return
     */
    @GetMapping(EndpointConstants.GET_BY_USERID)
    public @ResponseBody
    OutputUserDto getUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    /**
     * Получение пользователя по номеру телефона
     * @param phoneNumber номер телефона
     * @return
     */
    @GetMapping(EndpointConstants.GET_BY_PHONENUMBER)
    public @ResponseBody
    OutputUserDto getUserByPhoneNumber(@PathVariable Integer phoneNumber) {
        return userService.findByPhoneNumber(phoneNumber);
    }

    /**
     * Добавление нового пользователя
     * @param inputUserDto Входное дто с информацией о пользователе
     */
    @PutMapping(EndpointConstants.PUT_CREATE)
    public void createUser(@RequestBody InputUserDto inputUserDto) {
        userService.saveUser(inputUserDto);
    }

    //TODO подумать о эксепшенах

}
