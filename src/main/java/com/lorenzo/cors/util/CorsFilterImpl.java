package com.lorenzo.cors.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Profile("!test")
public class CorsFilterImpl implements CORSFilter {
	
	private static final String ORIGIN 					= "Origin";
	private static final String ALLOW_ORIGIN 			= "Acces-Control-Allow-Origin";
	private static final String ALLOW_CREDENTIALS 		= "Acces-Control-Allow-Credentials";
	private static final String ALLOW_METHODS 			= "Acces-Control-Allow-Methods";
	private static final String METHODS 				= "POST, PUT, DELETE, GET, OPTION";
	private static final String MAX_AGE 				= "Acces-Control-Max-Age";
	private static final String EXPOSE_HEADERS 			= "Acces-Control-Expose-Headers";
	private static final String ALLOW_HEADERS 			= "Acces-Control-Allow-Headers";
	
	public CorsFilterImpl () {
		System.out.println("Cors implement init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		String origin = servletRequest.getHeader(ORIGIN);
		System.out.println(origin);
		servletResponse.setHeader(ALLOW_ORIGIN, origin);
		servletResponse.setHeader(ALLOW_CREDENTIALS, "true");
		servletResponse.setHeader(ALLOW_METHODS, METHODS);
		servletResponse.setHeader(MAX_AGE, "3600");
		// PUEDES AGREGAR OTROS HEADERS DEPENDIENDO DE TUS REQUERIMIENTOS
		servletResponse.setHeader(EXPOSE_HEADERS, "Authorization");
		servletResponse.setHeader(ALLOW_HEADERS, "Content-Type, Accept, Authorization, X-XSRF-TOKEN");
		chain.doFilter(request, response);
	}

	
}
