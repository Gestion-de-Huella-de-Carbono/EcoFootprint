package ecoFootprint.service.impl;
import java.util.List;
import ecoFootprint.model.Person;
import ecoFootprint.model.CarbonFootprint;
import ecoFootprint.repository.PersonRepository;
import ecoFootprint.repository.CarbonFootprintRepository;
import ecoFootprint.service.EcoFootprintService;

public class EcoFootprintServiceImpl implements EcoFootprintService{
	
	private final PersonRepository personRepository;
    private final CarbonFootprintRepository carbonFootprintRepository;
    
    public EcoFootprintServiceImpl(PersonRepository personRepository, CarbonFootprintRepository carbonFootprintRepository) {
        this.personRepository = personRepository;
        this.carbonFootprintRepository = carbonFootprintRepository;
    }
    @Override
	public List<Person> findAllPersons() {
		return personRepository.findAll();		
	}
	@Override
	public List<CarbonFootprint> findAllCarbonFootprintData() {
		return carbonFootprintRepository.findAll();
	}
	@Override
	public List<Person> showSameAgePeople(int age) {
		List<Person> allPersons = personRepository.findAll();
		return personRepository.showSameAgePeople(allPersons, age);
	}	
}
