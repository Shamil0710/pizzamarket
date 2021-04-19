package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.constants.EndpointConstants;
import com.pizzamarket.pizzamarket.dto.CreateUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Контролер для доступа к пользователям
 */
@Slf4j
@RestController(value = EndpointConstants.USER)
public class UsersController {

    @Autowired
    private UserService userService;

    /**
     * ПОлучение полного списка пользователей
     *
     * @return
     */
    @GetMapping(EndpointConstants.USER_GET_ALL)
    public List<OutputUserDto> allUsers() {
        log.info("Получение полного списка пользователей");

        return userService.findAll();
    }

    /**
     * Получение пользователя по id
     *
     * @param userId id пользователя
     * @return
     */
    @GetMapping(EndpointConstants.USER_GET_BY_USERID)
    public @ResponseBody
    OutputUserDto getUserById(@PathVariable Long userId) {
        log.info("Получение пользователя по id " + userId.toString() + "\n{}");

        return userService.findById(userId);
    }

    /**
     * Получение пользователя по номеру телефона
     *
     * @param phoneNumber номер телефона
     * @return
     */
    @GetMapping(EndpointConstants.USER_GET_BY_PHONENUMBER)
    public @ResponseBody
    OutputUserDto getUserByPhoneNumber(@PathVariable String phoneNumber) {
        log.info("Получение пользователя по номеру телефона " + phoneNumber + "\n{}");

        return userService.findByPhoneNumber(phoneNumber);
    }

    /**
     * Добавление нового пользователя
     *
     * @param inputUserDto Входное дто с информацией о пользователе
     */
    @PutMapping(EndpointConstants.USER_PUT_CREATE)
    public void createUser(@RequestBody CreateUserDto inputUserDto) {
        log.info("Создание нового пользователя");

        userService.saveUser(inputUserDto);
    }

    @PutMapping(EndpointConstants.USER_DELETE)
    public void deleteUser(@PathVariable String phoneNumber) {
        log.info("Удаление пользователя по номеру телефона " + phoneNumber + "\n{}");

        userService.deleteByPhoneNumber(phoneNumber);
    }
}
