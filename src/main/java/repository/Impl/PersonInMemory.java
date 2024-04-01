package repository.Impl;

import data.Person;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonInMemory implements PersonRepository {

    private List<Person> person;

    public PersonInMemory() {
        this.person = new ArrayList<>();

    @Override
    public List<Person> findAll() {
        return null;
    }
}
