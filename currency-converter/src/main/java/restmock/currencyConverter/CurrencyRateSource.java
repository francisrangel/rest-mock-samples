package restmock.currencyConverter;

public class CurrencyRateSource {
	
	public static RESTCurrencyRate getProduction() {
		return new RESTCurrencyRate("http://www.webservicex.net/currencyconvertor.asmx/ConversionRate?FromCurrency=BRL&ToCurrency=USD");
	}
	
	public static RESTCurrencyRate getDEV() {
		return new RESTCurrencyRate("http://localhost:9080/currencyconverter");
	}

}
