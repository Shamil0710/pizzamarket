package com.pizzamarket.pizzamarket.services.mappers;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImp implements UserMapper {

    @Override
    public User tuUser(InputUserDto inputUserDto) {

        User user = new User();

        user.setUsername(inputUserDto.getName());
        user.setPassword(inputUserDto.getPassword());
        user.setPhoneNumber(inputUserDto.getPhoneNumber());

        return user;
    }

    @Override
    public OutputUserDto toDto(User user) {

        return new OutputUserDto(user.getId(), user.getUsername(), user.getPhoneNumber());
    }
}
