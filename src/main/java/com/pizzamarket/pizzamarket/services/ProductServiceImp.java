package com.pizzamarket.pizzamarket.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.repositorys.ProductRepository;
import com.pizzamarket.pizzamarket.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.MappingException;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(InputProductDto inputProductDto) {

        try {
            log.info("Добавление товара", MapperUtils.MAPPER.writeValueAsString(inputProductDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputProductDto");
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void upgradeUProduct(InputProductDto inputProductDto) {

    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
