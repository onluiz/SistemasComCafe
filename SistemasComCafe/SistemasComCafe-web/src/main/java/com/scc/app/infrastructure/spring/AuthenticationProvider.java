package com.scc.app.infrastructure.spring;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("authenticate");
		String login = extractLogin(authentication);
		String plainPassword = extractPassword(authentication);
		
		System.out.println(login);
		System.out.println(plainPassword);
		
		return authentication;
	}
	
	private String extractLogin(final Authentication authentication) {
		final String login = authentication.getPrincipal().toString();
		if (login.trim().isEmpty())
			throw new AuthenticationServiceException("");
		else
			return login;
	}
	
	private String extractPassword(final Authentication authentication) {
		final String password = authentication.getCredentials().toString();
		if (password.trim().isEmpty())
			throw new AuthenticationServiceException("");
		else
			return password;
	}

	public boolean supports(Class<? extends Object> arg0) {
		System.out.println("supports");
		return true;
	}

	
	
}
