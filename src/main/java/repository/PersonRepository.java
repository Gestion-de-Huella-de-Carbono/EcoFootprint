package repository;

import java.util.List;
import java.util.Optional;

import data.Person;

public interface PersonRepository {
    List <Person> findAll(); // listar todas las personas
    List<Person> showSameAgePeople(int age); // listar las personas de una misma edad
    default Optional<Person> save(Person person) {
        return null;
    } // agregar una persona nueva
}
