package ecoFootprint.service;

import java.util.List;

import ecoFootprint.exception.CarbonFootprintNotFoundException;
import ecoFootprint.exception.EcoFootprintException;
import ecoFootprint.exception.PersonNotFoundException;
import ecoFootprint.model.Person;
import ecoFootprint.model.CarbonFootprint;

public interface EcoFootprintService {
	List<Person> findAllPersons();
	List<Person> showSameAgePeople(int age);
	List<Person> findByAgeBetween(int minAge, int maxAge);
	List<Person> findByCity(String city);
	List<Person> findByName(String name);

	Person savePerson(Person person) throws PersonNotFoundException;
	Person updatePerson(Long id, Person updatedPerson) throws PersonNotFoundException;
	void deletePersonById(Long id) throws PersonNotFoundException;

	CarbonFootprint saveCarbonFootprint(CarbonFootprint carbonFootprint);
	CarbonFootprint updateCarbonFootprint(Long id, CarbonFootprint updatedCarbonFootprint) throws CarbonFootprintNotFoundException;
	void deleteCarbonFootprintByPersonId(Long personId) throws CarbonFootprintNotFoundException;

	Person getPersonById(Long id) throws PersonNotFoundException;
	CarbonFootprint getCarbonFootprintByPersonId(Long personId) throws CarbonFootprintNotFoundException;
}
