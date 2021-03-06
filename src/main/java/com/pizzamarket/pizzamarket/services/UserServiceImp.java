package com.pizzamarket.pizzamarket.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.repositorys.UserRepository;
import com.pizzamarket.pizzamarket.services.mappers.UserMapperImp;
import com.pizzamarket.pizzamarket.utils.MapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapperImp userMapperImp;

    @Override
    public User createUser(InputUserDto inputUserDto) {

        try {
            log.info("Добавление пользователя", MapperUtils.MAPPER.writeValueAsString(inputUserDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("Ошибка маппинга inputUserDto");
        }

        return userRepository.save(userMapperImp.tuUser(inputUserDto));
    }

    @Override
    public void deleteById(Long id) {
        log.info("Удаление пользователя по ID" + id.toString() + "\n{}");
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByPhoneNumber(InputUserDto inputUserDto) {
        log.info("Удаление пользователя по номеру телеофа" + inputUserDto.getPhoneNumber().toString() + "\n{}");
        //TODO Надо бы придумать
        deleteById(findByPhoneNumber(inputUserDto.getPhoneNumber()));
    }

    @Override
    public void upgradeUser(InputUserDto inputUserDto) {
        //TODO Придумать по кросате, жи есть жи
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByPhoneNumber(Integer phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
