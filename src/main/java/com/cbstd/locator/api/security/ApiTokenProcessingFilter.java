package com.cbstd.locator.api.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.cbstd.locator.service.UserService;
import com.cbstd.locator.sys.util.StringUtil;

@Component("apiTokenProcessingFilter")
public class ApiTokenProcessingFilter extends
		GenericFilterBean {
	
	public final String HEADER_SECURITY_TOKEN = "locatorApiToken";

	@Autowired
	UserService userService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String token = ((HttpServletRequest)request).getHeader(HEADER_SECURITY_TOKEN);
		
		if(!StringUtil.isNullOrEmpty(token))
		{
			// TODO : Check token and get username
			String username = "TEST";
	
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					"TEST", "TEST",
					authorities); // this.authenticationProvider.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		chain.doFilter(request, response);

	}


}
