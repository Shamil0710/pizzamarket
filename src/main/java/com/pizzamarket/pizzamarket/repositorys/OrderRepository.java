package com.pizzamarket.pizzamarket.repositorys;

import com.pizzamarket.pizzamarket.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с заказами
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

   List<Order> findAllByUser_PhoneNumber(String phoneNumber); //TODO разобратся с запросом

   List<Order> findAllByUserPhoneNumber(String phoneNumber);
}
