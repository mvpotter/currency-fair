/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 30/03/15
 * Time: 10:31
 */
package io.github.mvpotter.rest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring security configuration.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static class Role {
        public static final String USER = "USER";
        public static final String ADMIN = "ADMIN";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/*").hasRole(Role.ADMIN)
                .antMatchers(HttpMethod.GET, "/stats/health").permitAll()
                .antMatchers(HttpMethod.GET, "/stats/*").hasRole(Role.ADMIN)
                .antMatchers(HttpMethod.GET, "/**").permitAll()
            .and().httpBasic();
    }

}
