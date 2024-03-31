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
	
	//Getters
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getCity() {
		return city;
	}
	public double getTotalCarbonFootprint() {
		return totalCarbonFootprint;
	}
	
	//Setters
	
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) {
	    this.age = age;
	}
	public void setCity(String city) {
        this.city = city;
    }
	public void setTotalCarbonFootprint(double totalCarbonFootprint) {
        this.totalCarbonFootprint = totalCarbonFootprint;
    }
}
