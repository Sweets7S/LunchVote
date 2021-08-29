package ru.lunchVote.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

// Sweets
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public ConfigSecurity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("SELECT login, password, active FROM users WHERE login=?")
                .authoritiesByUsernameQuery("SELECT login, role FROM users WHERE login=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/cafe")
                .hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable(); // отключение логина для постмана

    }
}
