/**
 * Greeting Service DEMO ,working with HolaRestController  
 */
package com.aiqifi.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ryan.W
 *
 */
@Configuration
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "greeting")
@Service("GreetingService")
@Configurable
public class GreetingService {
	private String saying; // default HOlaaaaa
	private String backendServiceHost; // default: localhost
	private int backendServicePort; // default: 8999
	private String backendServiceUrl;
     
	private RestTemplate template;
	
	public String greeting(RestTemplate rTemplate) {
////		backendServiceUrl = String.format("http://%s:%d/api/backend?greeting={greeting}", backendServiceHost,
//				backendServicePort);
		backendServiceUrl="http://127.0.0.1:8999/api/backend?greeting=holaaaaaaa";
		
		System.out.println("URL:"+backendServiceUrl);
		template=rTemplate;
		Greeting response = template.getForObject(backendServiceUrl, Greeting.class, saying);
		return response.getGreeting() + " at host: " + response.getIp();
	}

	public String getSaying() {
		return saying;
	}

	public void setSaying(String saying) {
		this.saying = saying;
	}

	public String getBackendServiceHost() {
		return backendServiceHost;
	}

	public void setBackendServiceHost(String backendServiceHost) {
		this.backendServiceHost = backendServiceHost;
	}

	public int getBackendServicePort() {
		return backendServicePort;
	}

	public void setBackendServicePort(int backendServicePort) {
		this.backendServicePort = backendServicePort;
	}

	public String getBackendServiceUrl() {
		return backendServiceUrl;
	}

	public void setBackendServiceUrl(String backendServiceUrl) {
		this.backendServiceUrl = backendServiceUrl;
	}

}
