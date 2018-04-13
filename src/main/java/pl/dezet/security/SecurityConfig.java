package pl.dezet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/register").permitAll()
				.antMatchers("/transit").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin()
				.and()
				.csrf().disable();
	}
	
}