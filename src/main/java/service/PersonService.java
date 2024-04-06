package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
            throw new PersonNotFoundException("Personas no encontradas");
        }
        return persons;
    }

    public void save (String fileAddress, List<Person> persons) {
        try {
            personRepository.save(fileAddress,persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> showSameAgePeople(ArrayList<Person> personList, int age) {

        var peopleWithSameAge = personRepository.showSameAgePeople(personList,age);

        return peopleWithSameAge;
    }
}
