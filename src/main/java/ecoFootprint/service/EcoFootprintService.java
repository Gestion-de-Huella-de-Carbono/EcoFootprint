package ecoFootprint.service;

import java.util.List;

import ecoFootprint.exception.CarbonFootprintNotFoundException;
import ecoFootprint.exception.PersonNotFoundException;
import ecoFootprint.model.Person;
import ecoFootprint.model.CarbonFootprint;

public interface EcoFootprintService {
	List<Person> findAllPersons();
	List<Person> showSameAgePeople(int age);
	List<Person> findByAgeBetween(int minAge, int maxAge);
	List<Person> findByCity(String city);
	List<Person> findByName(String name);

	Person getPersonById(Long id) throws PersonNotFoundException;
	Long findPersonIdByNameAndLastNameAndAgeAndCity(String name, String lastName, int age, String city) throws PersonNotFoundException;
	Person savePerson(Person person);
	Person updatePerson(Long id, Person updatedPerson) throws PersonNotFoundException;
	void deletePersonById(Long id) throws PersonNotFoundException;

	CarbonFootprint saveCarbonFootprint(CarbonFootprint carbonFootprint);
	CarbonFootprint updateCarbonFootprint(Long id, CarbonFootprint updatedCarbonFootprint) throws CarbonFootprintNotFoundException;
}
