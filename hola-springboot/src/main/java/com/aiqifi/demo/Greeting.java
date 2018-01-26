/**
 * entity bean of Greeting.
 */
package com.aiqifi.demo;

/**
 * @author Ryan.W
 *
 */
public class Greeting {
	
	private String greeting;
	private long time;
	private String ip;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

}
