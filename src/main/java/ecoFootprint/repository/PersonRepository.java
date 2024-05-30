package ecoFootprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecoFootprint.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List <Person> findbyAge(int age); //el metodo "showSameAgePeople" al ser uno personalizado debe ser definido explicitamente en la interfaz
}
