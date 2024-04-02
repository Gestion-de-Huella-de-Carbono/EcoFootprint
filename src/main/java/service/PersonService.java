package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import data.Person;
import exception.person.PersonNotFoundException;
import repository.PersonRepository;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    
    public List<Person> findAll() throws PersonNotFoundException {

        var persons = personRepository.findAll();

        if (persons.isEmpty()) {
            throw new PersonNotFoundException();
        }
        return persons;
    }

    public void save (String fileAddress, ArrayList<?> arrayList) {
        try {
            personRepository.save(fileAddress, arrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> showSameAgePeople(ArrayList<Person> personList, int age) {

        var peopleWithSameAge = personRepository.showSameAgePeople(personList,age);

        return peopleWithSameAge;
    }
}
