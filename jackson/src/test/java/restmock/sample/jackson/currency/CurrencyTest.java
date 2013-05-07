package restmock.sample.jackson.currency;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import restmock.RestMock;
import restmock.sample.jackson.BaseTest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CurrencyTest extends BaseTest {
	
	@BeforeClass
	public static void configure() {
		setupServer();
	}
	
	private static void setupServer() {
		RestMock.whenGet("/currency/dolar").thenReturnJSON(0.5);
		RestMock.startServer();
	}
	
	@Test
	public void realShouldBeConvertedToDolar() {
		Currency real = new Currency("real", 15.0);
		
		Converter converter = new Converter();
		converter.addConversion("real", "dolar", getConversionRate("dolar"));
		
		Currency dolar = converter.convert(real, "dolar");
		
		assertEquals(7.5, dolar.getAmount(), 0);
	}

	private double getConversionRate(String currency) {
		WebResource webResource = client.resource(ADDRESS + ":" + PORT + "/currency/" + currency);
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);		
		assertEquals(200, response.getStatus());
		
		double rate = Double.parseDouble(response.getEntity(String.class));
		
		return rate;
	}

}
