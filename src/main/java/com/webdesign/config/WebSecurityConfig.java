package com.webdesign.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.webdesign.controller.PermissionController;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	// autowire the database credentials to
	@Autowired
	public DataSource ds;
	
	PermissionController permission = new PermissionController();
	
	// set access to pages before and after login
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
            .antMatchers("/", "/welcome", "/about", "/contact", "/sendMail",
            		"/projects", "/services", "/saved", "/error").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").permitAll().defaultSuccessUrl("/admin", true)
                .and()
            .logout()
                .permitAll();
    	// did this to disable csrf error from post methods
    	http.csrf().disable();
    }

    // autowire the credentials
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
   
        // select username and password from database
        auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
    }
     
    // all access to these folders
    @Override
	public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/images/**", "/resources/**", "/static/**");
    }
}