package com.ndhl.web.backend.security;

import com.ndhl.web.backend.common.AbstractEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebCommonSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .antMatchers(AbstractEndpoint.BASE_PATH + "/classes/**").permitAll()
                .and().cors()
                .and()
//                .addFilterBefore(new UserAuthenticateFilter(), BasicAuthenticationFilter.class)
                .exceptionHandling()
                .and().csrf().disable();
        // @formatter:on
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(AbstractEndpoint.WEBAPP_ALLOWED_UNAUTHENTICATED_PATHS.toArray(String[]:: new));
    }

}
