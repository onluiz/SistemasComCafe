package com.scc.app.infrastructure.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {

	public void onAuthenticationFailure(final HttpServletRequest request,final HttpServletResponse response, final AuthenticationException exception) throws IOException, ServletException {
		response.sendRedirect(request.getContextPath() + "/login?login_error=true");
	}
	
}
