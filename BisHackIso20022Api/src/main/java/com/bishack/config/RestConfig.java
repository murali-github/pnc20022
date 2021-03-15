
package com.bishack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class RestConfig {
	
	private static final String ALLOW_ORIGIN 					= "Access-Control-Allow-Origin";

	private static final String ALLOW_CREDENTIALS 				= "Access-Control-Allow-Credentials";

	private static final String ALLOW_METHODS 					= "Access-Control-Allow-Methods";

	private static final String ALLOW_HEADERS 					= "Access-Control-Allow-Headers";

	private static final String REQUEST_HEADERS 				= "Access-Control-Request-Headers";

	private static final String REQUEST_ORIGIN 					= "Origin";

	private static final String METHOD_OPTIONS 					= "OPTIONS";
	
	private static final String METHOD_GET 						= "GET";
	
	private static final String METHOD_POST 					= "POST";
	
	private static final String METHOD_PUT 						= "PUT";
	
	private static final String METHOD_DELETE 					= "DELETE";
	
	private static final String HEADER_AUTHORIZATION			= "Authorization";
	
    /**
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedOrigin(REQUEST_ORIGIN);
        config.addAllowedMethod(METHOD_OPTIONS);
        config.addAllowedMethod(METHOD_GET);
        config.addAllowedMethod(METHOD_POST);
        config.addAllowedMethod(METHOD_PUT);
        config.addAllowedMethod(METHOD_DELETE);
        config.addAllowedHeader("*");
        config.addAllowedHeader(ALLOW_CREDENTIALS);
        config.addAllowedHeader(ALLOW_HEADERS);
        config.addAllowedHeader(ALLOW_METHODS);
        config.addAllowedHeader(REQUEST_HEADERS);
        config.addAllowedHeader(HEADER_AUTHORIZATION);
        config.addAllowedHeader(REQUEST_HEADERS);
        config.addAllowedHeader(REQUEST_HEADERS);
        config.addAllowedHeader(ALLOW_ORIGIN);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}