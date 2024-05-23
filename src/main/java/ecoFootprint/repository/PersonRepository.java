package ecoFootprint.repository;

import java.io.IOException;
import java.util.List;

import ecoFootprint.model.Person;

public interface PersonRepository {
    List <Person> findAll(); // listar todas las personas
    List<Person> showSameAgePeople(List<Person> personList, int age); // listar las personas de una misma edad
    void save(String fileAddress, List<Person> persons) throws IOException; // agregar una persona nueva

}
