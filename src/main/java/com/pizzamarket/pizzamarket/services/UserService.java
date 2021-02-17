package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Метод добавление пользователя в базу
     * @param inputUserDto
     * @return
     */
    User saveUser(InputUserDto inputUserDto);

    /**
     * Метод удаления пользователя из базы
     * @param id
     */
    void deleteById(Long id);

    /**
     * Удаление пользователя из базы
     * @param inputUserDto
     */
    void deleteByPhoneNumber(InputUserDto inputUserDto);

    /**
     * Обновление даных у пользователе
     * @param inputUserDto
     */
    void upgradeUser(InputUserDto inputUserDto);

    /**
     * Поиск пользователя по id
     * @param id
     * @return
     */
    Optional<User> findById(Long id);

    /**
     * Поиск пользователя по нормеру телефона
     * @param phoneNumber
     * @return
     */
    List<User> findByPhoneNumber(Integer phoneNumber);

    List<User> findAll();
}
