package restmock.currencyConverter;

import java.math.BigDecimal;

public class App {
	
	public static void main(String[] args) {
		CurrencyRate currencyRate = CurrencyRateSource.getProduction();
		CurrencyConverter currencyConvertor = new CurrencyConverter(currencyRate);
		
		System.out.println("Loading... ");
		System.out.println("Current Value of Real: US$ " + currencyConvertor.toDollar(BigDecimal.ONE));
		System.out.println("Current Value of Dollar: R$ " + currencyConvertor.toReal(BigDecimal.ONE));
	}

}
