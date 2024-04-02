package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import data.Person;
import exception.person.SavingPersonException;
import exception.person.PersonNotFoundException;
import repository.PersonRepository;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    
    public List<Person> findAll() throws PersonNotFoundException {

        var persons = personRepository.findAll();
                                                       //error por PersonException
        if (persons.isEmpty()) {
            throw new PersonNotFoundException("Personas no encontradas");
        }
        
        return persons;
    }

    public Person save(Person person) throws SavingPersonException {    //falta person exception

        Optional<Person> optPerson = personRepository.save(person);

        return optPerson.orElseThrow();
    }

    public List<Person> showSameAgePeople(int edad) {
        // Obtener todas las personas
        List<Person> personas = personRepository.findAll();

        // Filtrar las personas por edad
        List<Person> personasConMismaEdad = new ArrayList<>();
        for (Person persona : personas) {
            if (persona.getAge() == edad) {
                personasConMismaEdad.add(persona);
            }
        }

        return personasConMismaEdad;
    }
}

/*
Explicacion:
PersonService es una clase que actúa como servicio para interactuar con la entidad Person a través del 
PersonRepository. El método findAll() busca y devuelve todas las personas dentro de los datos.
El método save(Person person) -el cual esta comentado- sirve para guardar una nueva persona en los datos y manejar 
posibles excepciones en caso de que ocurra algún error durante el proceso. 
*/