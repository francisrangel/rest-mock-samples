package restmock.sample.jackson.currency;

import java.util.HashMap;
import java.util.Map;

public class Converter {

	private Map<String, Map<String, Double>> conversions = new HashMap<String, Map<String, Double>>();

	public Currency convert(Currency currency, String to) {
		if (!conversions.containsKey(currency.getName()))
			throw new RuntimeException("No conversion rate set to currency " + currency.getName());
		if (!conversions.get(currency.getName()).containsKey(to))
			throw new RuntimeException("No conversion rate set from " + currency.getName() + " to " + to);
			
		return new Currency(to, currency.getAmount() * conversions.get(currency.getName()).get(to));
	}

	public void addConversion(String from, String to, double conversionRate) {
		Map<String, Double> newRate = new HashMap<String, Double>();
		newRate.put(to, conversionRate);
		conversions.put(from, newRate);
	}

}
