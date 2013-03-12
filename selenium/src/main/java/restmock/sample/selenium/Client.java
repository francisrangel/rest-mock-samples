package restmock.sample.selenium;

public class Client {

	private final String name;
	private final String address;

	public Client(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}
