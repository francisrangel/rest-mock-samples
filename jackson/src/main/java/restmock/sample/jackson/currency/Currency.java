package restmock.sample.jackson.currency;

public class Currency {

	private String name;
	private double amount;

	public Currency(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAmount() {
		return amount;
	}

}
