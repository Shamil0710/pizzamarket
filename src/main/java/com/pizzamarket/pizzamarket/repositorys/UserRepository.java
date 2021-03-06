package com.pizzamarket.pizzamarket.repositorys;

import com.pizzamarket.pizzamarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByPhoneNumber(Integer phoneNumber);
    User findByUsername(String userName);

}
