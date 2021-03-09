package com.pizzamarket.pizzamarket.services.mappers.imp;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.services.mappers.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImp implements UserMapper {

    @Override
    public User tuUser(InputUserDto inputUserDto) {

        User user = new User();

        user.setFirstName(inputUserDto.getFirstName());
        user.setPassword(inputUserDto.getPassword());
        user.setPhoneNumber(inputUserDto.getPhoneNumber());
        user.setLastName(inputUserDto.getLastName());

        return user;
    }

    @Override
    public OutputUserDto toDto(User user) {

        return new OutputUserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    }
}
