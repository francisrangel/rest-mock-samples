package restmock.currencyConverter;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import restmock.RestMock;
import restmock.currencyConverter.CurrencyConverter;
import restmock.currencyConverter.CurrencyRateSource;

public class CurrencyConvertorFunctionalTest {
	
	private CurrencyConverter convertor = 
			new CurrencyConverter(CurrencyRateSource.getDEV());
	
	@BeforeClass
	public static void init() throws FileNotFoundException {
		RestMock.whenGet("/currencyconverter").thenReturnXMLFromResource("rate.xml");
		RestMock.startServer();
	}
	
	@Test
	public void dollarToRealConvertion() {
		BigDecimal dollar = new BigDecimal("5.0");
		BigDecimal expected = new BigDecimal("10.00");

		assertEquals(expected, convertor.toReal(dollar));
	}
	
	@Test
	public void realToDollarConvertion() {
		BigDecimal real = new BigDecimal("5.0");
		BigDecimal expected = new BigDecimal("2.50");
		
		assertEquals(expected, convertor.toDollar(real));
	}
	
}
