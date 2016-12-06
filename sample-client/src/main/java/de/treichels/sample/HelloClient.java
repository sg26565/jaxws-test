package de.treichels.sample;

import java.net.MalformedURLException;
import java.net.URL;

import de.treichels.webservice.Hello;
import de.treichels.webservice.HelloService;

public class HelloClient {
	public static void main(final String[] args) throws MalformedURLException {
		final HelloService service = new HelloService(new URL("http://localhost:8080/ws/hello?wsdl"));
		final Hello hello = service.getHelloPort();

		System.out.print(hello.sayHello());
	}
}
