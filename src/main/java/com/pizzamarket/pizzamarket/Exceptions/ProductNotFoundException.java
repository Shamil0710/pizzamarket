package com.pizzamarket.pizzamarket.Exceptions;

/**
 * Исключение, генерируемое в случае если продукт не найден
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
