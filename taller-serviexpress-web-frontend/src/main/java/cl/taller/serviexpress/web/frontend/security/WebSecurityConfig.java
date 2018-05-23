package cl.taller.serviexpress.web.frontend.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configura SpringSecurity
 *
 * $Id: WebSecurityConfig.java 282 2016-08-12 21:05:58Z jnirian $ $Revision: 282
 * $
 * 
 * @author ochandia
 *
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public final Integer SESSION_TIMEOUT_IN_SECONDS = 6000 * 3000;

	@Override
	public void configure(WebSecurity security) {
		security.ignoring().antMatchers("/webjars/**", "/css/**", "/img/**", "/js/**", "/info/**", "/ajax/**",
				"/user/**", "/**");
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {

		security.csrf().disable().authorizeRequests().
		antMatchers("/**", "/user/**", "/assignprofile/**").permitAll()
				.and().logout().permitAll();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
}
