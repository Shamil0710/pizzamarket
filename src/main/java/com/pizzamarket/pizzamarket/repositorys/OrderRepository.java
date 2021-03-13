package com.pizzamarket.pizzamarket.repositorys;

import com.pizzamarket.pizzamarket.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

   List<Order> findAllByUser_PhoneNumber(Integer phoneNumber); //TODO разобратся с запросом
}
