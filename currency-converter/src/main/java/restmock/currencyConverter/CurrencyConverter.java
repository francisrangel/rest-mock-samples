package restmock.currencyConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {

	private final CurrencyRate currencyRate;

	public CurrencyConverter(CurrencyRate currencyRate) {
		this.currencyRate = currencyRate;
	}

	public BigDecimal toDollar(BigDecimal real) {
		return real.multiply(currencyRate.getCurrentRate());
	}

	public BigDecimal toReal(BigDecimal dollar) {
		return dollar.divide(currencyRate.getCurrentRate(), 2, RoundingMode.HALF_UP);
	}

}
