package repository;

import java.util.List;
import java.util.Optional;

import data.Person;

public interface PersonRepository {
    List <Person> findAll();
    default Optional<Person> save(Person person) {
        return null;
    }
}
