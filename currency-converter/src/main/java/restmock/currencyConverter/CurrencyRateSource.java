package restmock.currencyConverter;

public class CurrencyRateSource {
	
	public static ExternalCurrencyRate getProduction() {
		return new ExternalCurrencyRate("http://www.webservicex.net/currencyconvertor.asmx/ConversionRate?FromCurrency=BRL&ToCurrency=USD");
	}
	
	public static ExternalCurrencyRate getDEV() {
		return new ExternalCurrencyRate("http://localhost:9080/currencyconverter");
	}

}
