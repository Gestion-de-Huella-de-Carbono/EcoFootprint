package data;
public class Person {
	private String name;
	private String lastName;
	private int age;
	private String city;
	private double totalCarbonFootprint;
	
	//Inicio del constructor
	public Person(String name,String lastName, int age, String city, double totalCarbonFootprint) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.totalCarbonFootprint = totalCarbonFootprint;
	}

	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}

	

	public void setTotalCarbonFootprint(double totalCarbonFootprint) {
        this.totalCarbonFootprint = totalCarbonFootprint;
    }

	public String toString() {
			return "[" + name + "," + lastName + "," + age + "," + city + "," + totalCarbonFootprint + "]";
	}
}
