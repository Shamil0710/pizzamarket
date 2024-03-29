package com.pizzamarket.pizzamarket.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Настройки доступа для различных контролеров
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Бин ответсвенный за шифрование
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().authorizeRequests().anyRequest().permitAll();

        /** Пример spring security реализации  **/
//        httpSecurity.csrf().and().cors()
//                .disable()
//                .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers(EndpointConstants.USER_PUT_CREATE).not().fullyAuthenticated()
//                //Доступно для всех пользователей
//                .antMatchers("/").permitAll()
//                //Доступно для пользователей с ролью ADMIN
//                .antMatchers(EndpointConstants.ORDER_GET_ALL, EndpointConstants.PRODUCT_PUT_CREATE,
//                        EndpointConstants.PRODUCT_UPGRADE, EndpointConstants.USER_GET_ALL,
//                        EndpointConstants.USER_GET_BY_PHONENUMBER, EndpointConstants.USER_GET_BY_USERID).hasRole("ADMIN")
//                //Доступно для пользователей с ролью USER
//                .antMatchers("/basket/**", EndpointConstants.ORDER_PUT_CREATE,
//                        EndpointConstants.ORDER_GET_BY_PHONENUMBER, EndpointConstants.ORDER_DELETE,
//                        EndpointConstants.PRODUCT_GET_ALL, EndpointConstants.PRODUCT_GET_BY_TAGS,
//                        EndpointConstants.PRODUCT_GET_PAGE).hasRole("USER")
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin().disable()
//                //Перенарпавление на главную страницу после успешного входа
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
    }
}

