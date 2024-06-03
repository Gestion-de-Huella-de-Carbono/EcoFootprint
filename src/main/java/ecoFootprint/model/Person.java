package ecoFootprint.model;

import jakarta.persistence.*;

import java.text.MessageFormat;


@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String lastName;
	private int age;
	private String city;
	private double totalCarbonFootprint;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private CarbonFootprint carbonFootprint;

	public Person(String name, String lastName, int age, String city, double carbonFootprint) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.totalCarbonFootprint = carbonFootprint;
	}

	public Person() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getTotalCarbonFootprint() {
		return totalCarbonFootprint;
	}

	public void setTotalCarbonFootprint(double carbonFootprint) {
		this.totalCarbonFootprint = carbonFootprint;
	}

	public CarbonFootprint getCarbonFootprint() {
		return carbonFootprint;
	}

	public void setCarbonFootprint(CarbonFootprint carbonFootprint) {
		this.carbonFootprint = carbonFootprint;
	}

	@Override
	public String toString() {
		return MessageFormat.format("{0},{1},{2},{3},{4},{5}", id, name, lastName, age, city, carbonFootprint);
	}
}
