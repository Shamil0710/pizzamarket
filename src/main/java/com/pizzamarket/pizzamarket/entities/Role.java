//package com.pizzamarket.pizzamarket.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.*;
//import java.util.Set;
//
////todo: комменты, жавадок, @Table и тд
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Role implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id; //todo: где колонка аннотация?
//    private String name;
//
//    @Transient
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> user;
//
//    @Override
//    public String getAuthority() {
//        return getName();
//    }
//}
