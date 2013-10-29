package restmock.currencyConverter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import restmock.currencyConverter.CurrencyConverter;
import restmock.currencyConverter.CurrencyRate;

public class CurrencyConvertorUnitTest {
	
	private CurrencyConverter convertor;
	
	@Before
	public void setup() {
		CurrencyRate rate = Mockito.mock(CurrencyRate.class);
		Mockito.when(rate.getCurrentRate()).thenReturn(new BigDecimal("0.5"));
		convertor = new CurrencyConverter(rate);
	}
	
	@Test
	public void dollarToRealConvertion() {
		BigDecimal dollar = new BigDecimal("5.00");
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
