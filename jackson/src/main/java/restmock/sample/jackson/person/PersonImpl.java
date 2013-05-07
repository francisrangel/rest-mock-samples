package restmock.sample.jackson.person;

class PersonImpl implements Person {

	private String name;
	private String address;
	
	//for Jackson
	PersonImpl() {}

	public PersonImpl(String name, String address) {
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
