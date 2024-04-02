package repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import data.Person;

public interface PersonRepository {
    List <Person> findAll(); // listar todas las personas
    List<Person> showSameAgePeople(List<Person> personList, int age); // listar las personas de una misma edad
    void save(String fileAddress, ArrayList<?> arrayList) throws IOException; // agregar una persona nueva

}
