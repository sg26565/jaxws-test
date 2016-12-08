package de.treichels.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Hello {
	private static final Properties PROPS = new Properties();

	static {
		try (final InputStream is = Hello.class.getResourceAsStream("/config.properties")) {
			if (is != null) {
				PROPS.load(is);
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(final String[] args) throws IOException {
		PROPS.setProperty("greeting", "Hello, World!");
		Endpoint.publish("http://localhost:8080/ws", new Hello());
	}

	@WebMethod
	public String sayHello() throws IOException {
		return PROPS.getProperty("greeting");
	}
}
