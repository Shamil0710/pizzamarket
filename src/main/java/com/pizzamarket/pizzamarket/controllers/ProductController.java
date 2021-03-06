package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

//    @GetMapping("user/{userId}")
//    public @ResponseBody
//    OutputUserDto getUserById(@PathVariable Long userId) {
//        return userMapperImp.toDto(userServiceImp.findById(userId).get());
//    }

    @Autowired
    private ProductServiceImp productServiceImp;




}
