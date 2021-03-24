package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.*;

import java.util.List;

public interface ProductService {

    /**
     * Сохранение нового продукта
     *
     * @param createUserDto
     */
    void createProduct(CreateProductDto createUserDto);

    /**
     * Метод удаление продукта по ID
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * Обновление товара
     *
     * @param inputProductDto
     */
    void updateProduct(InputProductDto inputProductDto);

    /**
     * Поиск товара по ID
     *
     * @param id
     * @return
     */
    OutputProductDto getById(Long id);

    /**
     * Получение всех продуктов
     *
     * @return
     */
    List<OutputProductDto> getAll();

    /**
     * Получение товаров с разбитием на странгицы
     * @param page Нормер страницы
     * @param pageSize КОличество элементов на стринце
     * @return список продуктов
     */
    List<OutputProductDto> getProductPage(Integer page, Integer pageSize);

    /**
     * Получение списка товара по тегам
     * @param productDto
     * @return список дто из продуктов по тэгам
     */
    List<OutputProductDto> getByTag(RequestProductDto productDto);

}
