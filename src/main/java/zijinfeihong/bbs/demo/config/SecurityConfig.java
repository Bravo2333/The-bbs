package zijinfeihong.bbs.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] NO_AUTH_LIST = {
            "/register",
            "/home",
//            "/sendIdentification",
//            "/Retrieve"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().cors()
                .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
                .and().logout().logoutUrl("/logout").permitAll()
                .and().authorizeRequests().antMatchers(NO_AUTH_LIST).permitAll()
                .and().authorizeRequests().anyRequest().authenticated();
}}
