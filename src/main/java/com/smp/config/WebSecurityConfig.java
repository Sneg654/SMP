package com.smp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by Sergey_Stefoglo on 1/26/2017.
 */
@Configuration
@ComponentScan({"com.smp"})
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //
    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    /**
     * {@inheritDoc}
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        try {
            auth.userDetailsService(userDetailsService);
            auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
        try {
            http
                    .authorizeRequests()
                    .antMatchers("/smp/**").permitAll()
                    .antMatchers("/state/*").access("hasAnyRole('USER','ADMIN')")
                    .antMatchers("/org/*").access("hasRole('ADMIN')")
                    .antMatchers("/users/*").access("hasRole('ADMIN')")
                    .antMatchers("/provider/*").access("hasAnyRole('USER','ADMIN')")
                    .antMatchers("/upl").access("hasAnyRole('USER','ADMIN')")
                    .antMatchers("/uploadFile").access("hasAnyRole('USER','ADMIN')")
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/login")
                    .successForwardUrl("/state/list")
                    .and()
                    .logout()
                    .logoutUrl("/logout").permitAll()
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .and()
                    .httpBasic()
                    .and()
                    .csrf().disable()

            ;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}