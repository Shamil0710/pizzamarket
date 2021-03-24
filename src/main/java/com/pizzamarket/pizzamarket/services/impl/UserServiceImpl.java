package com.pizzamarket.pizzamarket.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pizzamarket.pizzamarket.Exceptions.UserNotFoundException;
import com.pizzamarket.pizzamarket.dto.CreateUserDto;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.mappers.impl.CreateUserDtoToUserMapper;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToUserMapper;
import com.pizzamarket.pizzamarket.mappers.impl.UserToDtoMapper;
import com.pizzamarket.pizzamarket.repositorys.UserRepository;
import com.pizzamarket.pizzamarket.services.UserService;
import com.pizzamarket.pizzamarket.utils.MapperUtils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


//todo: разбирайся с секьюром
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToDtoMapper userToDtoMapper;

    @Autowired
    private DtoToUserMapper dtoToUserMapper;

    @Autowired
    private CreateUserDtoToUserMapper createUserDtoToUserMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Метод добавления нового пользователя
     * @param createUserDto входящее дто
     * @return
     */
    @Override
    public void saveUser(CreateUserDto createUserDto) {
        try {
            log.info("Добавление пользователя {}", MapperUtils.MAPPER.writeValueAsString(createUserDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("Ошибка маппинга inputUserDto");
        }

        User user = new User();

        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setPhoneNumber(createUserDto.getPhoneNumber());
        user.setPassword(bCryptPasswordEncoder.encode(createUserDto.getPassword()));

        userRepository.save(user);
    }

    /**
     * Удаление пользователя по id
     * @param id id ользователя
     */
    @Override
    public void deleteById(Long id) {
        log.info("Удаление пользователя по ID" + id.toString() + "\n{}");
        userRepository.deleteById(id);
    }

    /**
     * Удаление пользователя по номеру ьелефона
     * @param phoneNumber Номер телефона
     */
    @Override
    public void deleteByPhoneNumber(String phoneNumber) {
        log.info("Удаление пользователя по номеру телеофа" + phoneNumber.toString() + "\n{}");
       userRepository.deleteById(userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Пользователь с номером телефона %s", phoneNumber))).getId());
    }

    /**
     * бновление пользователя согласно входящему дто
     * @param inputUserDto входное дто
     */
    @Override
    public void upgradeUser(InputUserDto inputUserDto) {
        try {
            log.info("Обновление пользователя {}", MapperUtils.MAPPER.writeValueAsString(inputUserDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputUserDto");
        }

       final User user = userRepository.findById(inputUserDto.getId()).orElseThrow(() -> new UserNotFoundException(
                String.format("Пользователь с id= %s не найден", inputUserDto.getId())));

        userRepository.deleteById(inputUserDto.getId());

            user.setPhoneNumber(inputUserDto.getPhoneNumber());
            user.setFirstName(inputUserDto.getFirstName());
            user.setLastName(inputUserDto.getLastName());
            user.setPassword(inputUserDto.getPassword());

        userRepository.save(user);
    }

    /**
     * Получение пользователя по id
     * @param id id пользователя
     * @return
     */
    @Override
    public OutputUserDto findById(Long id) {
        log.info("Получение пользователя по ID {}" + id + "\n{}");

        return userToDtoMapper.convert(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                String.format("Пользователь с id= %s не найден", id))));
    }

    /**
     * Получение пользователя по номеру телефона
     * @param phoneNumber номер телефона
     * @return
     */
    @Override
    public OutputUserDto findByPhoneNumber(String phoneNumber) {
        log.info("Получение пользователя по ID {}" + phoneNumber + "\n{}");

        return userToDtoMapper.convert(userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UserNotFoundException(
                String.format("Пользователь с номером телефона %s не найден", phoneNumber))));
    }

    /**
     * Метод получени полного списка пользователей
     * @return
     */
    public List<OutputUserDto> findAll() {
        log.info("Получение полного списка пользователей");

        return userToDtoMapper.convertAll(userRepository.findAll());
    }

    //TODO говно для сикюра
    //В моем случаи уникальным юсер неймом будет номер телефона
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { //TODO нахуя? апд Разобратся с сраным сикьюром
//        User user = userRepository.findByUsername(userName);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }

        return null;
    }
}
