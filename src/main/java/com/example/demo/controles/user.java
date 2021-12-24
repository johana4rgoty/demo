package com.example.demo.controles;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@ConfigurationProperties
public class user extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/", "/not-restricted"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }


    
}
