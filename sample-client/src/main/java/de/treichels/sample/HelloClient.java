package de.treichels.sample;

import java.net.MalformedURLException;
import java.net.URL;

import de.treichels.webservice.Hello;
import de.treichels.webservice.HelloService;

public class HelloClient {
	public static void callService(final URL wsdl) {
		final HelloService service = new HelloService(wsdl);
		final Hello hello = service.getHelloPort();

		System.out.println(hello.sayHello());
	}

	public static void main(final String[] args) throws MalformedURLException {
		callService(new URL("http://localhost:8080/dev/ws?wsdl"));
		callService(new URL("http://localhost:8080/qa/ws?wsdl"));
		callService(new URL("http://localhost:8080/prod/ws?wsdl"));
	}
}
