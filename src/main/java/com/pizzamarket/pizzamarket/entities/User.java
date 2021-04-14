package com.pizzamarket.pizzamarket.entities;

import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Сущность отображающая пользователя
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "user", schema = "mampiza")
public class User implements UserDetails, Serializable {

    /**
     * id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    /**
     * Пароль пользователя
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Номер телефона, он же выполняет фкнкции логина
     */
    @Column(name = "phone_number", nullable = false)
    @Size(min = 8, max = 8)
    private String phoneNumber;

    @Transient
    private String passwordConfirm;

    /**
     * Список ролей
     */
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "roles_users",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<>();


    //Имплементация интерфейса UserDetails необходимого для работы СпрингСикъюра
    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Transient
    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return false;
    }
}
