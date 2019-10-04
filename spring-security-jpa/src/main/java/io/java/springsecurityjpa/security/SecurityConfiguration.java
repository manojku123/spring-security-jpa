package io.java.springsecurityjpa.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		/*auth.inMemoryAuthentication()
		.withUser("user")
		.password("user")
		.roles("user")
		.and()
		.withUser("admin")
		.password("admin")
		.roles("admin");*/
		
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/").hasRole("user")
		.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder setPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
}