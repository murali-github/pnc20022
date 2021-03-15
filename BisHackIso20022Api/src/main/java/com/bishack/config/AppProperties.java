package com.bishack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
    @PropertySource("classpath:application.properties")
})
public class AppProperties {
	
	@Autowired
    private Environment env;
	
	@Value("${mongodb.dumpLoc}")
	private String mongodbDumpLoc;

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getMongodbDumpLoc() {
		return mongodbDumpLoc;
	}

	public void setMongodbDumpLoc(String mongodbDumpLoc) {
		this.mongodbDumpLoc = mongodbDumpLoc;
	}
	
	

}
