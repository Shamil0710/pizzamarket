package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.dto.RequestProductDto;
import com.pizzamarket.pizzamarket.services.ProductService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Контролер для получния информации о товаре
 */
@Slf4j
@RestController(value = EndpointConstants.PRODUCT)
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Метод получения полного перичня товаров
     * @return
     */
    @GetMapping(EndpointConstants.GET_ALL)
    public List<OutputProductDto> getAllProduct() {
        return productService.getAll();
    }

    /**
     * Получение заданой страницы с указаным количеством итемов
     * @param productDto входной дто
     * @return
     */
    @GetMapping(EndpointConstants.GET_PRODUCT_PAGE)
    List<OutputProductDto> getPage(@PathVariable RequestProductDto productDto) {
        return productService.getPage(productDto.getPage(), productDto.getCount());
    }

    /**
     * Добавление нового продукта
     * @param inputProductDto входное дто
     */
    @PutMapping(EndpointConstants.PUT_CREATE)
    void createProduct(@RequestBody InputProductDto inputProductDto) {
        productService.createProduct(inputProductDto);
    }

    /**
     * Одновление существующего товара
     * @param inputProductDto входное дто
     */
    @PutMapping(EndpointConstants.UPGRADE_PRODUCT)
    void upgradeProduct(@RequestBody InputProductDto inputProductDto) {
        productService.updateProduct(inputProductDto);
    }

    /**
     * дто запроса продуктов
     * @param productDto дто запроса продуктов
     * @param bindingResult возращает ошибки валидации
     * @return
     */
    @PostMapping(EndpointConstants.GET_BY_TAGS)
    ResponseEntity<List<OutputProductDto>> getFilteredPages(@Valid RequestProductDto productDto, BindingResult bindingResult) {
        log.info("Запрос по тэгам");
        //При наличии оишбок валидации логируем ошибки и отдаем BAD_REQUEST
        if (bindingResult.hasErrors()) {
            log.info("Ошибка валидации ожидаемого запроса");
            bindingResult.getAllErrors().stream().map(ObjectError::toString).forEach(log::info);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productService.getByTag(productDto));
    }

    //TODO Фильтрация по названию...
}
