package com.pizzamarket.pizzamarket.Exceptions;

/**
 * Исключение, генерируемое в случае если пользователь не найден
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
