package restmock.sample.jackson.person;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import restmock.RestMock;
import restmock.sample.jackson.BaseTest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JacksonTest extends BaseTest {
	
	@BeforeClass
	public static void configure() {
		setupServer();
	}
	
	private static void setupServer() {
		RestMock.whenGet("/clients/1").thenReturnJSON(new PersonImpl("Test", "Test St."));
		RestMock.startServer();
	}
	
	@AfterClass
	public static void stopServer() {
		RestMock.stopServer();
	}
	
	@Test
	public void clientsListShouldBeReturnedAsJson() throws Exception {		
		WebResource webResource = client.resource(ADDRESS + ":" + PORT + "/clients/1");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);		
		assertEquals(200, response.getStatus());
		
		PersonImpl person = mapper.readValue(response.getEntityInputStream(), PersonImpl.class);
		
		assertEquals("Test", person.getName());
		assertEquals("Test St.", person.getAddress());
	}

}
