package com.aiqifi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@RestController
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/boot")
	public String myIndex() {
		return "HAHA,Boot";
	}
	
	@RequestMapping("abc")
	public String myAbc() {
		return "HAHA,ABC ABC";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	

}
