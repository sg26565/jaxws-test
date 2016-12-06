package de.treichels.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Hello {
	public static void main(final String[] args) {
		Endpoint.publish("http://localhost:8080/ws/hello", new Hello());
	}

	@WebMethod
	public String sayHello() {
		return "Hello, World!";
	}
}
