package za.ac.mzilikazi.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Created by Ernst on 2017/09/05.
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.inMemoryAuthentication().withUser("user").password("user")
                .roles("USER").and().withUser("asavela").password("asavela").roles("ADMIN");
    }
}
