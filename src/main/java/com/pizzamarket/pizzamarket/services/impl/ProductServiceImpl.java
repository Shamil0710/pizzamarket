package com.pizzamarket.pizzamarket.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.pizzamarket.pizzamarket.Exceptions.ProductNotFoundException;
import com.pizzamarket.pizzamarket.dto.CreateProductDto;
import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.dto.RequestProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.mappers.impl.CreateProductDtoToProductMapper;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToProductMapper;
import com.pizzamarket.pizzamarket.mappers.impl.ProductToDtoMapper;
import com.pizzamarket.pizzamarket.repositorys.ProductRepository;
import com.pizzamarket.pizzamarket.services.ProductService;
import com.pizzamarket.pizzamarket.utils.MapperUtils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.MappingException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Сервис для работы с товарами
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DtoToProductMapper dtoToProductMapper;

    @Autowired
    private ProductToDtoMapper productToDtoMapper;

    @Autowired
    private CreateProductDtoToProductMapper createProductDtoToProductMapper;

    /**
     * Метод создание нового товара
     *
     * @param createProductDto дто для создания нового обьекта
     */
    @Override
    public void createProduct(CreateProductDto createProductDto) {
        try {
            log.info("Добавление товара {}", MapperUtils.MAPPER.writeValueAsString(createProductDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputProductDto");
        }

        productRepository.save(createProductDtoToProductMapper.convert(createProductDto));
    }

    /**
     * Метод удаление товара по id
     *
     * @param id id товара
     */
    @Override
    public void deleteById(Long id) {
        log.info("Удаление продукта с ID " + id.toString());

        productRepository.deleteById(id);
    }

    //todo: для кастомных ошибок, и не только, но и в целом, нужно описать RestControllerAdvice

    /**
     * Метод обновления информации о товаре
     *
     * @param inputProductDto входное дто
     */
    @Override
    public void updateProduct(InputProductDto inputProductDto) {
        try {
            log.info("Обновление товара {}", MapperUtils.MAPPER.writeValueAsString(inputProductDto));

            final Product product = productRepository.findById(inputProductDto.getId())
                    .orElseThrow(() -> new ProductNotFoundException(
                            String.format("Продукт с id= %s не найден", inputProductDto.getId())));

            product.setCost(inputProductDto.getCost());
            product.setDescription(inputProductDto.getDescription());
            product.setTag(inputProductDto.getTag());
            product.setTitle(inputProductDto.getTitle());

            productRepository.save(product);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputProductDto");
        }
    }

    /**
     * Получение товара по id
     *
     * @param id id товара
     * @return
     */
    @Override
    public OutputProductDto getById(Long id) {
        log.info("Получение товара по id= " + id.toString() + "\n{}");

        return productToDtoMapper.convert(productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(
                String.format("Продукт с id= %s не найден", id))));
    }

    /**
     * Получение полного списка товаров
     *
     * @return
     */
    @Override
    public List<OutputProductDto> getAll() {
        log.info("Получение полного списка товаров");

        return productToDtoMapper.convertAll(productRepository.findAll());
    }

    /**
     * Метод получение товаров с разбивкой на страницы
     *
     * @param page     Нормер страницы
     * @param pageSize Количество элементов на стринце
     * @return
     */
    @Override
    public List<OutputProductDto> getProductPage(Integer page, Integer pageSize) {
        log.info("Получение списка товаров со страницы " + page.toString() + " с " + pageSize.toString() + " товарами");

        return productToDtoMapper.convertAll(productRepository.findAll(PageRequest.of(page, pageSize)).getContent());
    }

    /**
     * Метод получения товаров с определенными тегами с разбивкой на страницы
     *
     * @param productDto входное дто
     */
    @Override
    public List<OutputProductDto> getByTag(RequestProductDto productDto) {
        log.info("Получение товаров соотвествующих тегам \n{}", productDto.getTags());

        return productToDtoMapper.convertAll(
                productRepository.findAllByTagIn(
                        productDto.getTags(), PageRequest.of(productDto.getPage(), productDto.getCount())).getContent());
    }
}
