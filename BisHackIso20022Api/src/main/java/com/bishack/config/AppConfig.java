
package com.bishack.config;

import java.io.IOException;
import java.util.List;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

import de.flapdoodle.embed.mongo.MongoDumpExecutable;
import de.flapdoodle.embed.mongo.MongoDumpStarter;
import de.flapdoodle.embed.mongo.MongoRestoreExecutable;
import de.flapdoodle.embed.mongo.MongoRestoreStarter;
import de.flapdoodle.embed.mongo.config.IMongoDumpConfig;
import de.flapdoodle.embed.mongo.config.IMongoRestoreConfig;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongoDumpConfigBuilder;
import de.flapdoodle.embed.mongo.config.MongoRestoreConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@Configuration
@EnableAsync
@EnableAspectJAutoProxy
@EnableCaching
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private AppProperties appProperties;
	
	@Autowired
    private CacheManager cacheManager;

	/**
	 * This CCLWebConfig sets the SecurityContextHolder Mode to
	 * INHERITABLETHREADLOCAL.
	 */
	public AppConfig() {
		super();
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		/* Enabling Cross-origin resource sharing. */
		http.cors();

		http.csrf().disable();

		http.headers().frameOptions().disable();

	}

	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

	@Bean(name = "swiftApiKeyRestTemplate")
	RestTemplate swiftApiKeyRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate swiftApiKeyRestTemplate = restTemplateBuilder
				.basicAuthentication("6cjb80WQ3LTO0PwCbGzYZ4vviE53Xhg3", "Ac88YfQqDPzLSFsb").build();
		List<ClientHttpRequestInterceptor> interceptors = swiftApiKeyRestTemplate.getInterceptors();
		interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE));

		swiftApiKeyRestTemplate.setInterceptors(interceptors);
		FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
		swiftApiKeyRestTemplate.getMessageConverters().add(formHttpMessageConverter);
		return swiftApiKeyRestTemplate;
	}

	@Bean(name = "swiftApiRestTemplate")
	RestTemplate swiftApiRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate swiftApiRestTemplate = restTemplateBuilder.build();
		List<ClientHttpRequestInterceptor> interceptors = swiftApiRestTemplate.getInterceptors();
		interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", MediaType.APPLICATION_JSON_VALUE));

		swiftApiRestTemplate.setInterceptors(interceptors);

		swiftApiRestTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		return swiftApiRestTemplate;
	}

	@Bean
	public MongoDumpExecutable mongoDBDumper(IMongodConfig mongodConfig) throws IOException {
		int port = mongodConfig.net().getPort();
		IMongoDumpConfig mongoDumpConfig = new MongoDumpConfigBuilder().version(Version.Main.PRODUCTION)
				.net(new Net(port, Network.localhostIsIPv6())).out(appProperties.getMongodbDumpLoc()).build();

		return MongoDumpStarter.getDefaultInstance().prepare(mongoDumpConfig);
	}

	@Bean
	public MongoRestoreExecutable mongoDbrestorer(IMongodConfig mongodConfig) throws IOException {
		int port = mongodConfig.net().getPort();
		IMongoRestoreConfig mongoRestoreConfig = new MongoRestoreConfigBuilder().version(Version.Main.PRODUCTION)
				.net(new Net(port, Network.localhostIsIPv6())).dropCollection(false)
				.dir(appProperties.getMongodbDumpLoc()).build();

		return MongoRestoreStarter.getDefaultInstance().prepare(mongoRestoreConfig);
	}
}