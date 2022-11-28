package com.example.token.sercurity;

import com.example.token.filter.CustomAuthenticationFilter;
import com.example.token.filter.CustomAuthorizationFilter;
import com.example.token.service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.http.HttpMethod.*;

@EnableWebSecurity
@Configuration
public class SercurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserImpl userDetails;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager()) ;
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests().antMatchers("/api/login/**", "/api/token/refresh/**").permitAll() ;
        http.authorizeHttpRequests().antMatchers(GET,"/api/account/**", "/api/employee/**")
                .hasAnyAuthority("ROLE_USER","ROLE_ADMIN");
        http.authorizeHttpRequests().antMatchers(DELETE, "/api/employee/**","/api/account/**" )
                .hasAuthority("ROLE_ADMIN");
        http.authorizeHttpRequests().antMatchers(PUT, "/api/employee/updatedto/**","/api/employee/**","/api/account/**")
                .hasAnyAuthority("ROLE_USER","ROLE_ADMIN");
        http.authorizeHttpRequests().antMatchers(POST, "/api/employee/createdto/**")
                .hasAnyAuthority("ROLE_ADMIN");
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter) ;
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}

