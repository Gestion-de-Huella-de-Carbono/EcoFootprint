package ecoFootprint.model;
public class Person {
	private String name;
	private String lastName;
	private int age;
	private String city;
	private double totalCarbonFootprint;
	

	public Person(String name,String lastName, int age, String city, double totalCarbonFootprint) {
		this.name = name;
		this.lastName = lastName;
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
			return "[" + name + "," + lastName + "," + age + "," + city + "," + totalCarbonFootprint + "]";
			// Devuelve una cadena que contiene el nombre, apellido, edad, ciudad y huella de carbono total de la persona,todo entre corchetes y separado por comas
	}

}
