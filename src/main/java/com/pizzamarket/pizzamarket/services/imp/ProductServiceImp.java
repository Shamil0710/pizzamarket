package com.pizzamarket.pizzamarket.services.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.repositorys.ProductRepository;
import com.pizzamarket.pizzamarket.services.ProductService;
import com.pizzamarket.pizzamarket.services.mappers.imp.ProductMapperImp;
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

    @Autowired
    ProductMapperImp productMapperImp;

    @Override
    public Product createProduct(InputProductDto inputProductDto) {
        try {
            log.info("Добавление товара", MapperUtils.MAPPER.writeValueAsString(inputProductDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputProductDto");
        }

        return productRepository.save(productMapperImp.toEntity(inputProductDto));
    }

    @Override
    public void deleteById(Long id) {
        log.info("Удаление пользователя с ID " + id.toString());
        productRepository.deleteById(id);
    }

    @Override
    public void upgradeProduct(InputProductDto inputProductDto) {
        try {
            log.info("Обновление товара", MapperUtils.MAPPER.writeValueAsString(inputProductDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MappingException("inputProductDto");
        }

        //TODO делать валидацию по наличию id
        Product product = productRepository.findById(inputProductDto.getId()).get();
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
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> getPage(Integer page, Integer pageSize) {
        log.info("Получение списка товаров со страницы " + page.toString() + "с " + pageSize.toString() + " товарами");
        return productRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    //TODO Нормально ли что контролер получает лист или нужно делать отдеьное дто?
    @Override
    public List<Product> getByTag(List<String> tags) {
        log.info("Получение товаров соотвествующих тегам " + tags + "\n{}");
        List<Product> productList = productRepository.findAll();
        for (String tag : tags){
           productList = productList.stream().filter(e -> e.getTag().contains(tag)).collect(Collectors.toList());
        }
        //TODO Я чет хз как реализовать и фильтрацию и разбиение по стринцам
        return productList;
    }
}
