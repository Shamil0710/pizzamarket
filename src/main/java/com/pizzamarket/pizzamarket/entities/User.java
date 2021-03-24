package com.pizzamarket.pizzamarket.entities;

import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

//todo: analogichno

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    @Size(min = 8, max = 8)
    private String phoneNumber;


    //Имплементация интерфейса UserDetails необходимого для работы СпрингСикъюра
    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Transient
    @Override
    public String getUsername() {
        return null;
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
