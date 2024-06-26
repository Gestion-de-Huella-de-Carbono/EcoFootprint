package ecoFootprint.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecoFootprint.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAge(int age);
    List<Person> findByCity(String city);
    List<Person> findByName(String name);
    List<Person> findByAgeBetween(int minAge, int maxAge);

    Optional<Person> findByNameAndLastNameAndAgeAndCity(String name, String lastName, int age, String city);
}