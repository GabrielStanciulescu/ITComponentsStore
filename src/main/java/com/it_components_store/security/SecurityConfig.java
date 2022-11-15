package com.it_components_store.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity()
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .mvcMatchers("/dashboard").hasAnyRole("ADMIN")
                .mvcMatchers("/category/1").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/category/2").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/category/3").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/category/4").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/category/5").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/category/6").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/category/7").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/category/8").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/orderpage").hasAnyRole("ADMIN")
                .mvcMatchers("/orderpage/dashboard").hasAnyRole("ADMIN")
                .and()
                .formLogin(form-> form.defaultSuccessUrl("/category/1")
                        .loginPage("/login").failureUrl("/login/error"));
    }
}
