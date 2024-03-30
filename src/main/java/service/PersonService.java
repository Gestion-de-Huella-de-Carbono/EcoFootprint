package service;

import java.util.List;

import data.Person;
import exception.PersonNotFoundException;
import repository.PersonRepository;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    
    public List<Person> findAll() /*throws PersonNotFoundException*/ {

        var persons = personRepository.findAll();
        /*                                               //error por la exception
        if (persons.isEmpty()) {
            throw new PersonNotFoundException();
        }
        */
        return persons;
    }

    /* 
                                                  ????
    public Person save(Person person) throws SavingPersonException {

	    Optional<Person> optPerson = personRepository.save( person );

	    return optPerson.orElseThrow(() -> new SavingPersonException( person ));
                                                        ????
     */

}

/*
Explicacion:
PersonService es una clase que actúa como servicio para interactuar con la entidad Person a través del 
PersonRepository. El método findAll() busca y devuelve todas las personas dentro de los datos.
El método save(Person person) -el cual esta comentado- sirve para guardar una nueva persona en los datos y manejar 
posibles excepciones en caso de que ocurra algún error durante el proceso. 
*/