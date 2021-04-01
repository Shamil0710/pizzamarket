package com.pizzamarket.pizzamarket.services.impl;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToBasketMapper;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToProductMapper;
import com.pizzamarket.pizzamarket.mappers.impl.ProductToDtoMapper;
import com.pizzamarket.pizzamarket.mappers.impl.ProductToInputDtoMapper;
import com.pizzamarket.pizzamarket.services.BasketService;
import com.pizzamarket.pizzamarket.services.RedisBasketService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы
 */
@Slf4j
@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    RedisBasketService redisBasketService;

    @Autowired
    DtoToBasketMapper dtoToBasketMapper;

    @Autowired
    DtoToProductMapper dtoToProductMapper;

    @Autowired
    ProductToDtoMapper productToDtoMapper;

    @Autowired
    ProductToInputDtoMapper productToInputDtoMapper;

//    @Autowired
//    BasketToDto basketToDto;


    /**
     * Метод создания новой корзины
     * @param basketDto дто корзины
     */
    @Override
    public void createBasket(BasketDto basketDto) {
        log.info("Создание коризны по номеру " + basketDto.getPhoneNumber() + "С товарами" + basketDto.getProducts().toString() + "\n{}");

        redisBasketService.setValue(basketDto.getPhoneNumber(), dtoToBasketMapper.convert(basketDto));
    }

    /**
     * Добавление товара в корзину
     * @param basketDto дто корзины
     */
    @Override
    public void addProductToBasket(BasketDto basketDto) {
        log.info("Добавление в коризну по номеру " + basketDto.getPhoneNumber() + "товара " + basketDto.getProducts().toString() + "\n{}");

        redisBasketService.addToBasket(basketDto.getPhoneNumber(), dtoToProductMapper.convertAll(basketDto.getProducts()));
    }

    /**
     * Метод удаление конкретного продукта из корзины
     * @param basketDto дто корзины
     */
    @Override
    public void deleteProductInBasket(BasketDto basketDto, InputProductDto inputProductDto) {
        log.info("Удаление из карзины по номеру " + basketDto.getPhoneNumber() + "товара " + dtoToProductMapper.convert(inputProductDto).toString() + "\n{}");

        redisBasketService.getBasket(basketDto.getPhoneNumber()).getProducts().remove(dtoToProductMapper.convert(inputProductDto));
    }

    /**
     * Метод получение корзины по номеру телефона
     * @param phoneNumber номер телефона
     * @return
     */
    @Override
    public BasketDto getBasket(String phoneNumber) {
        //TODO Костыль с дто, я заебался, пусть пока так
        BasketDto basketDto = new BasketDto(productToInputDtoMapper.convertAll(redisBasketService.getBasket(phoneNumber).getProducts()), phoneNumber);

        return basketDto;
    }
}
