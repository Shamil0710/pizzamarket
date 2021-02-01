package com.pizzamarket.pizzamarket.services.mappers;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;

public interface UserMapper {

    /**
     * Преобразование из входящего дто в сущность
     * @param inputUserDto
     * @return
     */
    User tuUser(InputUserDto inputUserDto);

    /**
     * Преобразование из сущности в дто
     * @param user
     * @return
     */
    OutputUserDto toDto(User user);
}
