package com.pizzamarket.pizzamarket.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Сущность обозначающая роли пользователей
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "mampiza", name = "roles")
public class Role implements GrantedAuthority {

    /**
     * id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id", nullable = false)
    private Long id;

    /**
     * Имя роли
     */
    @Column(name = "roles_name", nullable = false)
    private String name;

    /**
     * Набор пользователей с данной ролью
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles_users",
            joinColumns = { @JoinColumn(name = "roles_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> user;

    /**
     * Реализация GrantedAuthority
     * @return
     */
    @Override
    public String getAuthority() {
        return getName();
    }
}
