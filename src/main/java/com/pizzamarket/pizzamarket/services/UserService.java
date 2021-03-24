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
     * @param createUserDto
     * @return
     */
    void saveUser(CreateUserDto createUserDto);

    /**
     * Метод удаления пользователя из базы
     * @param id
     */
    void deleteById(Long id);

    /**
     * Удаление пользователя из базы
     * @param phoneNumber
     */
    void deleteByPhoneNumber(String phoneNumber);

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
    OutputUserDto findById(Long id);

    /**
     * Поиск пользователя по нормеру телефона
     * @param phoneNumber
     * @return
     */
    OutputUserDto findByPhoneNumber(String phoneNumber);

    /**
     * Получение полного списка клиентов
     * @return
     */
    List<OutputUserDto> findAll();
}
