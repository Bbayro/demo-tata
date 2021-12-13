package com.Currency.Converter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTAuthorizationFilter filter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // activar CORS y No CSRF
        http
                .cors().and().csrf().disable();

        // JWT autorizar endpoints / requests
        http
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().authenticated();

        // JWT filtro token
        http
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);

        http = http.exceptionHandling().authenticationEntryPoint(
                (request, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
                }).and();

//        http
//                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class)
//                .cors().and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/authenticate").permitAll()
//                .anyRequest().authenticated();
    }
}