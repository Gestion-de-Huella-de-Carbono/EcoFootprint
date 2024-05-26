package ecoFootprint.service;

import java.util.List;
import ecoFootprint.model.Person;
import ecoFootprint.model.CarbonFootprint;

public interface EcoFootprintService {
	List<Person> findAllPersons();
	List<CarbonFootprint> findAllCarbonFootprintData();
	List<Person> showSameAgePeople(int age);
}
