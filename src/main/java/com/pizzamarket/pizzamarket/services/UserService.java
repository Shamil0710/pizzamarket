package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.CreateUserDto;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Метод добавление пользователя в базу
     *
     * @param createUserDto дто создания пользователя
     */
    void saveUser(CreateUserDto createUserDto);

    /**
     * Метод удаления пользователя из базы
     *
     * @param id id пользователя
     */
    void deleteById(Long id);

    /**
     * Удаление пользователя из базы
     *
     * @param phoneNumber номер телефона
     */
    void deleteByPhoneNumber(String phoneNumber);

    /**
     * Обновление даных у пользователе
     *
     * @param inputUserDto дто пользователя
     */
    void upgradeUser(InputUserDto inputUserDto);

    /**
     * Поиск пользователя по id
     *
     * @param id id пользователя
     * @return дто пользователя
     */
    OutputUserDto findById(Long id);

    /**
     * Поиск пользователя по нормеру телефона
     *
     * @param phoneNumber номер телефона
     * @return дто пользователя
     */
    OutputUserDto findByPhoneNumber(String phoneNumber);

    /**
     * Получение полного списка пользователей
     *
     * @return лист дто пользователя
     */
    List<OutputUserDto> findAll();
}
