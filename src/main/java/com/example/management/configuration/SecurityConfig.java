package com.example.management.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().
                disable()
                .authorizeRequests()
                .antMatchers("/role/add").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/role/list").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll()
              //  .antMatchers(HttpMethod.OPTIONS,"/providers/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

}
