/**
 * 
 */
package com.aiqifi.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Ryan.W
 *
 */

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "holaapp")
@Configurable
public class HolaRestController {
	private String siteName = null;
	
	@Autowired
	private GreetingService GS;  //=new GreetingService() ;
	
	private RestTemplate template= new RestTemplate();
	
	@RequestMapping(method = RequestMethod.POST, value = "/hola", produces = "text/plain")
	public String hola() throws UnknownHostException {
		String hostname = null;

		try {
			hostname = InetAddress.getLocalHost().getHostAddress();

		} catch (UnknownHostException e) {
			hostname = "unknown";
		}

		return "Hola Spring Boot de " + hostname;
	}

	/**
	 * if the services is dynamically scaled ,to identify the service 
	 * is important.  external properties set in application.properties   
	 * @return siteName
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/whoareyou", produces = "text/plain")
	public String whoAreYou() {

		return " I'am " + siteName;
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/backend", produces = "text/plain")
	public String greetingFormBackend() {
        String str= GS.greeting(template);
         
	    return str;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	
}
