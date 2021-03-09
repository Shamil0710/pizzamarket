package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.services.imp.ProductServiceImp;
import com.pizzamarket.pizzamarket.services.mappers.imp.ProductMapperImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

//    @GetMapping("user/{userId}")
//    public @ResponseBody
//    OutputUserDto getUserById(@PathVariable Long userId) {
//        return userMapperImp.toDto(userServiceImp.findById(userId).get());
//    }

    @Autowired
    private ProductServiceImp productServiceImp;

    @Autowired
    private ProductMapperImp productMapperImp;

    @GetMapping("product/all")
    public @ResponseBody
    List<OutputProductDto> getAllProduct() {
        return productServiceImp.getAll().stream()
                .map(e -> productMapperImp.toDto(e))
                .collect(Collectors.toList());
    }

    @GetMapping("product/{page}/{pageSize}")
    List<OutputProductDto> getPage(@PathVariable Integer page, Integer pageSize) {
        return productServiceImp.getPage(page, pageSize).stream()
                .map(e -> productMapperImp.toEntity(e))
                .collect(Collectors.toList());
    }

    @PutMapping("product/create")
    void createProduct(@RequestBody InputProductDto inputProductDto) {
        productServiceImp.createProduct(inputProductDto);
    }

    @PutMapping("product/upgrade")
    void upgradeProduct(@RequestBody InputProductDto inputProductDto) {
        productServiceImp.upgradeProduct(inputProductDto);
    }

    @GetMapping("product/filetr/{page}/{pageSize}")
    List<OutputProductDto> getFilteredPages(Integer page, Integer pageSize, List<String> tags) {
        List<OutputProductDto> outputProductDtoList = productServiceImp.getByTag(tags).stream()
                .map(e -> productMapperImp.toDto(e))
                .collect(Collectors.toList());

    }

}
