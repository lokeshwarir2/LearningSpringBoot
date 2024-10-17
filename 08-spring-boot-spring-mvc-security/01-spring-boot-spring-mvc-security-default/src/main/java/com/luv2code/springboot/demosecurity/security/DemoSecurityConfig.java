package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john= User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("Employee")
//                .build();
//        UserDetails mary= User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("Employee","Manager")
//                .build();
//        UserDetails susan=User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("Employee","Manager","Admin")
//                .build();
//        return new InMemoryUserDetailsManager(john,mary,susan);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configure->configure.requestMatchers("/").hasRole("Employee")
                .requestMatchers("/leaders/**").hasRole("Manager")
                .requestMatchers("/systems/**").hasRole("Admin")
                .anyRequest().authenticated()).formLogin(form->form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                ).logout(logout->logout.permitAll()
                ).exceptionHandling(configurer->configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }

    }

