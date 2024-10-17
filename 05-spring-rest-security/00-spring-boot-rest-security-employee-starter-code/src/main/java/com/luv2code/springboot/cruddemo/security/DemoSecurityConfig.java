package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
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
//        UserDetails loki= User.builder()
//                .username("loki")
//                .password("{noop}abc123")
//                .roles("Employee")
//                .build();
//        UserDetails vicky=User.builder()
//                .username("vicky")
//                .password("{noop}abc123")
//                .roles("Employee","Manager","Admin")
//                .build();
//        return new InMemoryUserDetailsManager(loki,vicky);
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("Employee")
                .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("Employee")
                .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("Manager")
                .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("Admin")
                .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("Manager"));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();

    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }
}
