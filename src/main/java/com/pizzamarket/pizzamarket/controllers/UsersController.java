package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.constants.EndpointConstants;
import com.pizzamarket.pizzamarket.dto.CreateUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Контролер для доступа к пользователям
 */
@RestController(value = EndpointConstants.USER)
public class UsersController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * ПОлучение полного списка пользователей
     * @return
     */
    @GetMapping(EndpointConstants.USER_GET_ALL)
    public List<OutputUserDto> allUsers() {
       return userService.findAll();
    }

    /**
     * Получение пользователя по id
     * @param userId id пользователя
     * @return
     */
    @GetMapping(EndpointConstants.USER_GET_BY_USERID)
    public @ResponseBody
    OutputUserDto getUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    /**
     * Получение пользователя по номеру телефона
     * @param phoneNumber номер телефона
     * @return
     */
    @GetMapping(EndpointConstants.USER_GET_BY_PHONENUMBER)
    public @ResponseBody
    OutputUserDto getUserByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.findByPhoneNumber(phoneNumber);
    }

    /**
     * Добавление нового пользователя
     * @param inputUserDto Входное дто с информацией о пользователе
     */
    @PutMapping(EndpointConstants.USER_PUT_CREATE)
    public void createUser(@RequestBody CreateUserDto inputUserDto) {
        userService.saveUser(inputUserDto);
    }

    //TODO подумать о эксепшенах

}
