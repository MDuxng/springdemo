package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource)
    {
        UserDetails user = User.builder()
                .username("user")
                .password("$2a$10$.5XlP8vg/Fsrn4MnWm/hieU2RCBop8pxbcp2T8OT8OqccxDw3P1yG")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$Q/DOLK66nqzjmj0V.m9HUewFNLt1IqgVSUzO367u4ga8vBrfukEm.")
                .roles("USER","ADMIN")
                .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
