package ecoFootprint;

import ecoFootprint.model.Person;
import ecoFootprint.model.CarbonFootprint;
import ecoFootprint.repository.PersonRepository;
import ecoFootprint.repository.CarbonFootprintRepository;
import ecoFootprint.service.impl.EcoFootprintServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EcoFootprintServiceImplTest {


    @InjectMocks
    private EcoFootprintServiceImpl ecoFootprintService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private CarbonFootprintRepository carbonFootprintRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    /*
    @Test
    void testFindAll() {
        List<Person> persons = Arrays.asList(new Person("John", 25), new Person("Jane", 30));
        when(personRepository.findAll()).thenReturn(persons);

        List<Person> result = ecoFootprintService.findAll();
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
    }

    @Test
    void testFindAllCarbonFootprints() {
        List<CarbonFootprint> footprints = Arrays.asList(new CarbonFootprint(10.5), new CarbonFootprint(15.3));
        when(carbonFootprintRepository.findAll()).thenReturn(footprints);

        List<CarbonFootprint> result = ecoFootprintService.findAllCarbonFootprints();
        assertEquals(2, result.size());
        assertEquals(10.5, result.get(0).getValue());
    }


    @Test
    void testFindByAge() {
        List<Person> persons = Arrays.asList(new Person("John", 25), new Person("Doe", 25));
        when(personRepository.findByAge(25)).thenReturn(persons);

        List<Person> result = ecoFootprintService.findByAge(25);
        assertEquals(2, result.size());
        assertEquals(25, result.get(0).getAge());
    }

    @Test
    void testSave() {
        Person person = new Person("John", 25);
        when(personRepository.save(person)).thenReturn(person);

        Person result = ecoFootprintService.save(person);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    void testDeletePersonById() {
        Long personId = 1L;
        doNothing().when(personRepository).deleteById(personId);

        ecoFootprintService.deletePersonById(personId);
        verify(personRepository, times(1)).deleteById(personId);
    }

    @Test
    void testUpdatePerson() {
        Long personId = 1L;
        Person person = new Person("John", 25);
        Person updatedPerson = new Person("John Doe", 26);
        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(personRepository.save(any(Person.class))).thenReturn(updatedPerson);

        Person result = ecoFootprintService.updatePerson(personId, updatedPerson);
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals(26, result.getAge());
    }

     */

}
