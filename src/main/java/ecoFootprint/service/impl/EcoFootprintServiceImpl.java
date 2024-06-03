package ecoFootprint.service.impl;


import ecoFootprint.exception.CarbonFootprintNotFoundException;
import ecoFootprint.exception.PersonNotFoundException;
import ecoFootprint.model.CarbonFootprint;
import ecoFootprint.model.Person;
import ecoFootprint.repository.CarbonFootprintRepository;
import ecoFootprint.repository.PersonRepository;
import ecoFootprint.service.EcoFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EcoFootprintServiceImpl implements EcoFootprintService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CarbonFootprintRepository carbonFootprintRepository;

	@Override
	public List<Person> findAllPersons() {
		List<Person> persons = personRepository.findAll();
		for (Person person : persons) {
			Optional<CarbonFootprint> carbonFootprintOpt = carbonFootprintRepository.findById(person.getId());
			if (carbonFootprintOpt.isPresent()) {
				CarbonFootprint carbonFootprint = carbonFootprintOpt.get();
				person.setTotalCarbonFootprint(carbonFootprint.getTotalCarbonFootprint());
			} else {
				person.setTotalCarbonFootprint(0.0);
			}
		}
		return persons;
	}


	@Override
	public List<Person> showSameAgePeople(int age) {
		return personRepository.findByAge(age);
	}

	@Override
	public List<Person> findByAgeBetween(int minAge, int maxAge) {
		return personRepository.findByAgeBetween(minAge, maxAge);
	}

	@Override
	public List<Person> findByCity(String city) {
		return personRepository.findByCity(city);
	}

	@Override
	public List<Person> findByName(String name) {
		return personRepository.findByName(name);
	}

	@Override
	public Person savePerson(Person person) {
		Person savedPerson = personRepository.save(person);
		CarbonFootprint carbonFootprint = new CarbonFootprint(3.0, 4.0, 2.0, 1.0, savedPerson); // Asegúrate de usar los valores correctos
		carbonFootprintRepository.save(carbonFootprint);
		savedPerson.setTotalCarbonFootprint(carbonFootprint.getTotalCarbonFootprint());
		return savedPerson;
	}


	@Override
	public CarbonFootprint saveCarbonFootprint(CarbonFootprint carbonFootprint) {
		return carbonFootprintRepository.save(carbonFootprint);
	}

	@Override
	public void deletePersonById(Long id) throws PersonNotFoundException {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.get();
			personRepository.delete(person);
		} else {
			throw new PersonNotFoundException(id);
		}
	}

	public void deleteCarbonFootprintByPersonId(Long personId) throws CarbonFootprintNotFoundException {
		CarbonFootprint carbonFootprint = carbonFootprintRepository.findById(personId)
				.orElseThrow(() -> new CarbonFootprintNotFoundException(personId));
		carbonFootprintRepository.delete(carbonFootprint);
	}

	@Override
	public CarbonFootprint getCarbonFootprintByPersonId(Long personId) throws CarbonFootprintNotFoundException {
		return carbonFootprintRepository.findById(personId)
				.orElseThrow(() -> new CarbonFootprintNotFoundException(personId));
	}

	@Override
	public Person getPersonById(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}


	@Override
	public Person updatePerson(Long id, Person updatedPerson) throws PersonNotFoundException {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.get();
			person.setName(updatedPerson.getName());
			person.setLastName(updatedPerson.getLastName());
			person.setAge(updatedPerson.getAge());
			person.setCity(updatedPerson.getCity());
			person.setTotalCarbonFootprint(updatedPerson.getTotalCarbonFootprint());
			personRepository.save(person);
			return person;
		} else {
			throw new PersonNotFoundException(id);
		}
	}

	@Override
	public CarbonFootprint updateCarbonFootprint(Long id, CarbonFootprint updatedCarbonFootprint) throws CarbonFootprintNotFoundException {
		Optional<CarbonFootprint> optionalCarbonFootprint = carbonFootprintRepository.findById(id);
		if (optionalCarbonFootprint.isPresent()) {
			CarbonFootprint carbonFootprint = optionalCarbonFootprint.get();
			carbonFootprint.setTransport(updatedCarbonFootprint.getTransport());
			carbonFootprint.setEnergy(updatedCarbonFootprint.getEnergy());
			carbonFootprint.setFood(updatedCarbonFootprint.getFood());
			carbonFootprint.setOther(updatedCarbonFootprint.getOther());
			carbonFootprintRepository.save(carbonFootprint);
			return carbonFootprint;
		} else {
			throw new CarbonFootprintNotFoundException(id);
		}
	}
}