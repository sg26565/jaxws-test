package de.treichels.sample;

import java.net.MalformedURLException;
import java.net.URL;

import de.treichels.webservice.Hello;
import de.treichels.webservice.HelloService;
import de.treichels.webservice.IOException_Exception;

public class HelloClient {
	public static void callService(final URL wsdl) throws IOException_Exception {
		final HelloService service = new HelloService(wsdl);
		final Hello hello = service.getHelloPort();

		System.out.println(hello.sayHello());
	}

	public static void main(final String[] args) throws MalformedURLException, IOException_Exception {
		callService(new URL("http://localhost:8080/dev/ws?wsdl"));
		callService(new URL("http://localhost:8080/qa/ws?wsdl"));
		callService(new URL("http://localhost:8080/prod/ws?wsdl"));
	}
}
