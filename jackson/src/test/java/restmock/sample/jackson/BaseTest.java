package restmock.sample.jackson;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;

public abstract class BaseTest {
	
	public static String ADDRESS = "http://localhost";
	public static String PORT = "9080";
	
	protected Client client = new Client();
	protected ObjectMapper mapper = new ObjectMapper();

}
