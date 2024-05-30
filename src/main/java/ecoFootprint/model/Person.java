package ecoFootprint.model;

import java.text.MessageFormat;

public class Person {
	private String name;
	private String lastName;
	private int age;
	private String city;
	private double totalCarbonFootprint;
	private long id;
	

	public Person(String name,String lastName, int age, long id, String city, double totalCarbonFootprint) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.age = age;
		this.city = city;
		this.totalCarbonFootprint = totalCarbonFootprint;
	}

	public int getAge() {
		return age;
	}


	public void setTotalCarbonFootprint(double totalCarbonFootprint) {
        this.totalCarbonFootprint = totalCarbonFootprint;
    }


	public String toString() {// Método toString para obtener una representación en forma de cadena de la instancia de la clase Person

		return MessageFormat.format("{0}, {1}, {2}, {3}, {4}, {5}", name, lastName, id, age,city, totalCarbonFootprint);
		// Devuelve una cadena que contiene el nombre, apellido, edad, ciudad y huella de carbono total de la persona
	}


	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public double getTotalCarbonFootprint() {
		return totalCarbonFootprint;
	}

	public long getId() {
		return id;
	}

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

	public void setId(long id) {
		this.id = id;
	}
}
