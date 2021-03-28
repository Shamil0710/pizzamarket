package com.pizzamarket.pizzamarket.repositorys;

import com.pizzamarket.pizzamarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Репозиторий для работы с клиентами
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);
//    List<User> findByUsername(String userName);

}
