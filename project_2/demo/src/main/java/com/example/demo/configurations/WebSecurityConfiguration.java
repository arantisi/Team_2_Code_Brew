package com.example.demo.configurations;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;



@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /*@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }*/


    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);

        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;
    }



    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable()
        http.authorizeRequests()
                //.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                //.antMatchers(HttpMethod.POST,"/watchlist/user/**")
                .antMatchers("/user")
                .hasAuthority("user")
                .anyRequest()
                .authenticated()
                *//*.antMatchers("/admin")
                .hasAuthority("admin")
                .anyRequest()
                .authenticated()*//*
                .and()
                .formLogin()
                .and()
                .logout()
                .addLogoutHandler(new HeaderWriterLogoutHandler(
                        new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.COOKIES)));

        http.csrf().disable();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable()
        http.authorizeRequests()
                //.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/user","/watchlist/user/**","/reviews/create/**")
                //.antMatchers("/user")
                .hasAuthority("user")
                .anyRequest()
                .authenticated()
                /*.antMatchers("/admin")
                .hasAuthority("admin")
                .anyRequest()
                .authenticated()*/
                .and()
                .formLogin()
                .and()
                .logout()
                .addLogoutHandler(new HeaderWriterLogoutHandler(
                        new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.COOKIES)));

        http.csrf().disable();
    }

}