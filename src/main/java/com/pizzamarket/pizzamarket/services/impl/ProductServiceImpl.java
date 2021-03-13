package com.pizzamarket.pizzamarket.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.dto.RequestProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.repositorys.ProductRepository;
import com.pizzamarket.pizzamarket.services.ProductService;
import com.pizzamarket.pizzamarket.services.mappers.imp.DtoToProductMapper;
import com.pizzamarket.pizzamarket.services.mappers.imp.ProductToDtoMapper;
import com.pizzamarket.pizzamarket.utils.MapperUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mapping.MappingException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;


//todo: комменты, жавадок, доработай сервис
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DtoToProductMapper dtoToProductMapper;

    @Autowired
    ProductToDtoMapper productToDtoMapper;

    @Override
    public Product createProduct(InputProductDto inputProductDto) {
        try {
            log.info("Добавление товара {}", MapperUtils.MAPPER.writeValueAsString(inputProductDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputProductDto");
        }

        //TODO Сделать проверку на наличие id  базе
        return productRepository.save(dtoToProductMapper.convert(inputProductDto));
    }

    @Override
    public void deleteById(Long id) {
        log.info("Удаление продукта с ID " + id.toString());
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(InputProductDto inputProductDto) {
        try {
            log.info("Обновление товара {}", MapperUtils.MAPPER.writeValueAsString(inputProductDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputProductDto");
        }

        Product product = productRepository.findById(inputProductDto.getId()).orElse(new Product()); //TODO Корректно ли так?;
        productRepository.deleteById(product.getId());

        if (inputProductDto.getCost() != null) {
            product.setCost(inputProductDto.getCost());
        }
        if (inputProductDto.getDescription() != null) {
            product.setDescription(inputProductDto.getDescription());
        }
        if (inputProductDto.getId() != null) {
            product.setTitle(inputProductDto.getTitle());
        }
        if (inputProductDto.getTag() != null) {
            product.setTag(inputProductDto.getTag());
        }
        if (inputProductDto.getId() != null) {
            product.setId(inputProductDto.getId());
        }

        productRepository.save(product);
    }

    @Override
    public OutputProductDto getById(Long id) {
        return productToDtoMapper.convert(productRepository.findById(id).orElse(new Product()));
    }

    @Override
    public List<OutputProductDto> getAll() {
        return productToDtoMapper.convertAll(productRepository.findAll());
    }

    @Override
    public List<OutputProductDto> getPage(Integer page, Integer pageSize) {
        log.info("Получение списка товаров со страницы " + page.toString() + "с " + pageSize.toString() + " товарами");
        return productToDtoMapper.convertAll(productRepository.findAll(PageRequest.of(page, pageSize)).getContent());
    }

    @Override
    public List<OutputProductDto> getByTag(RequestProductDto productDto) {
        log.info("Получение товаров соотвествующих тегам \n{}", productDto.getTags());
        return productToDtoMapper.convertAll(
                productRepository.findAllByTagIn(
                        productDto.getTags(), PageRequest.of(productDto.getPage(), productDto.getCount())).getContent());
    }
}
