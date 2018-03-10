package com.example.movieCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.movieCollection.controller.UserDetailServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;	
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/css/**").permitAll() // Enable css when logged out
        .antMatchers("/index", "/movielist", "/movie/{id}").hasAnyAuthority("USER","ADMIN") //All users can access these endpoints
        .antMatchers("/add", "/save", "/delete/{id]}", "/edit/{id}").hasAuthority("ADMIN")	//Only admin can access these endpoints
        .anyRequest().authenticated()
        .and()
        .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/index")
          .permitAll()
        .and()
        .logout()
          .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	//Use BCrypt password encoder
    	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    	
    }

}
