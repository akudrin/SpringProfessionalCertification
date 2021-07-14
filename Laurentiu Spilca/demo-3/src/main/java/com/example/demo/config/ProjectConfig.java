package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		var c = clientRegistration();
		return new InMemoryClientRegistrationRepository(c);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.oauth2Login();
		http.authorizeRequests().anyRequest().authenticated();

	}

	private ClientRegistration clientRegistration() {
		return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("c0f3b3235d2515f61826")
				.clientSecret("3498d0fdb83f4e6e1fdfcb4c8c4f8908e27077de").build();

	}

}
