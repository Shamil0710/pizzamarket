package com.pizzamarket.pizzamarket.services.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pizzamarket.pizzamarket.Exceptions.NotFoundException;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.repositorys.UserRepository;
import com.pizzamarket.pizzamarket.services.UserService;
import com.pizzamarket.pizzamarket.services.mappers.imp.DtoToUserMapper;
import com.pizzamarket.pizzamarket.services.mappers.imp.UserToDtoMapper;
import com.pizzamarket.pizzamarket.utils.MapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToDtoMapper userToDtoMapper;

    @Autowired
    private DtoToUserMapper dtoToUserMapper;

    /**
     * Метод добавления нового пользователя
     * @param inputUserDto входящее дто
     * @return
     */
    @Override
    public User createUser(InputUserDto inputUserDto) {

        try {
            log.info("Добавление пользователя", MapperUtils.MAPPER.writeValueAsString(inputUserDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("Ошибка маппинга inputUserDto");
        }

        return userRepository.save(dtoToUserMapper.convert(inputUserDto));
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
    public void deleteByPhoneNumber(Integer phoneNumber) {
        log.info("Удаление пользователя по номеру телеофа" + phoneNumber.toString() + "\n{}");
        deleteById(userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new NotFoundException())  //TODO Да как бля
                .getId());
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

        User user = userRepository.findById(inputUserDto.getId()).orElse(new User()); //TODO корректно ли так?

        userRepository.deleteById(inputUserDto.getId());

        if(inputUserDto.getPhoneNumber() != null) {
            user.setPhoneNumber(inputUserDto.getPhoneNumber());
        }
        if(inputUserDto.getFirstName() != null) {
            user.setFirstName(inputUserDto.getFirstName());
        }
        if(inputUserDto.getId() != null) {
            user.setId(inputUserDto.getId());
        }
        if(inputUserDto.getLastName() != null) {
            user.setLastName(inputUserDto.getLastName());
        }
        if(inputUserDto.getPassword() != null) {
            user.setPassword(inputUserDto.getPassword());
        }

        userRepository.save(user);
    }

    /**
     * Получение пользователя по id
     * @param id id пользователя //TODO ужно ли переделывать на получение дто?
     * @return
     */
    @Override
    public OutputUserDto findById(Long id) {
        return userToDtoMapper.convert(userRepository.findById(id).orElseThrow()); //TODO как правильно работать с опционалом
    }

    /**
     * Получение пользователя по номеру телефона
     * @param phoneNumber номер телефона //TODO ужно ли переделывать на получение дто?
     * @return
     */
    @Override
    public OutputUserDto findByPhoneNumber(Integer phoneNumber) {
        return userToDtoMapper.convert(userRepository.findByPhoneNumber(phoneNumber).orElseThrow()); //TODO как правильно работать с опционалом
    }

    /**
     * Метод получени полного списка пользователей
     * @return
     */
    public List<OutputUserDto> findAll() {
        return userToDtoMapper.convertAll(userRepository.findAll());
    }

    //В моем случаи уникальным юсер неймом будет номер телефона
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { //TODO нахуя? апд Разобратся с сраным сикьюром
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
