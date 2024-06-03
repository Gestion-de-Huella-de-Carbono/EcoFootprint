package ecoFootprint;

import ecoFootprint.exception.CarbonFootprintNotFoundException;
import ecoFootprint.exception.PersonNotFoundException;
import ecoFootprint.model.CarbonFootprint;
import ecoFootprint.model.Person;
import ecoFootprint.repository.CarbonFootprintRepository;
import ecoFootprint.repository.PersonRepository;
import ecoFootprint.service.impl.EcoFootprintServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class EcoFootprintServiceImplTest {

    @InjectMocks
    private EcoFootprintServiceImpl ecoFootprintService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private CarbonFootprintRepository carbonFootprintRepository;

    private Person person1;
    private Person person2;
    private CarbonFootprint carbonFootprint1;
    private CarbonFootprint carbonFootprint2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        person1 = new Person("John", "Doe", 30, "New York", 0.0);
        person1.setId(1L);

        person2 = new Person("Jane", "Doe", 25, "Los Angeles", 0.0);
        person2.setId(2L);

        carbonFootprint1 = new CarbonFootprint(3.0, 4.0, 2.0, 1.0, person1); // Total: 10.0
        carbonFootprint1.setId(1L);

        carbonFootprint2 = new CarbonFootprint(5.0, 3.0, 4.0, 2.0, person2); // Total: 14.0
        carbonFootprint2.setId(2L);
    }

    @Test
    void when_FindAllPersons_should_return_all_persons_with_carbon_footprint() {
        person1.setCarbonFootprint(carbonFootprint1);
        person2.setCarbonFootprint(carbonFootprint2);

        when(personRepository.findAll()).thenReturn(List.of(person1, person2));
        when(carbonFootprintRepository.findById(person1.getId())).thenReturn(Optional.of(carbonFootprint1));
        when(carbonFootprintRepository.findById(person2.getId())).thenReturn(Optional.of(carbonFootprint2));

        List<Person> persons = ecoFootprintService.findAllPersons();

        assertEquals(2, persons.size());
        assertEquals(carbonFootprint1.getTotalCarbonFootprint(), persons.get(0).getTotalCarbonFootprint());
        assertEquals(carbonFootprint2.getTotalCarbonFootprint(), persons.get(1).getTotalCarbonFootprint());
    }

    @Test
    void when_ShowSameAgePeople_should_return_persons_with_same_age() {
        when(personRepository.findByAge(25)).thenReturn(List.of(person1));

        List<Person> persons = ecoFootprintService.showSameAgePeople(25);

        assertEquals(1, persons.size());
        assertEquals(person1, persons.get(0));
    }

    @Test
    void when_FindByAgeBetween_should_return_persons_within_age_range() {
        when(personRepository.findByAgeBetween(20, 30)).thenReturn(List.of(person1, person2));

        List<Person> persons = ecoFootprintService.findByAgeBetween(20, 30);

        assertEquals(2, persons.size());
    }

    @Test
    void when_FindByCity_should_return_persons_from_city() {
        when(personRepository.findByCity("Ciudad1")).thenReturn(List.of(person1));

        List<Person> persons = ecoFootprintService.findByCity("Ciudad1");

        assertEquals(1, persons.size());
        assertEquals(person1, persons.get(0));
    }

    @Test
    void when_FindByName_should_return_persons_with_name() {
        when(personRepository.findByName("Nombre1")).thenReturn(List.of(person1));

        List<Person> persons = ecoFootprintService.findByName("Nombre1");

        assertEquals(1, persons.size());
        assertEquals(person1, persons.get(0));
    }

    @Test
    void when_SavePerson_should_save_person_and_carbon_footprint() {
        when(personRepository.save(person1)).thenReturn(person1);
        when(carbonFootprintRepository.save(any(CarbonFootprint.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Person savedPerson = ecoFootprintService.savePerson(person1);

        assertEquals(person1, savedPerson);

        assertEquals(carbonFootprint1.getTotalCarbonFootprint(), savedPerson.getTotalCarbonFootprint());
    }

    @Test
    void when_DeletePersonById_should_delete_person_and_carbon_footprint() throws PersonNotFoundException {
        when(personRepository.findById(person1.getId())).thenReturn(Optional.of(person1));
        when(carbonFootprintRepository.findById(person1.getId())).thenReturn(Optional.of(carbonFootprint1));

        ecoFootprintService.deletePersonById(person1.getId());

        verify(personRepository, times(1)).delete(person1);
    }


    @Test
    void when_UpdatePerson_should_update_person() throws PersonNotFoundException {
        when(personRepository.findById(person1.getId())).thenReturn(Optional.of(person1));

        Person updatedPerson = new Person("NombreActualizado", "ApellidoActualizado", 35, "CiudadActualizada", 0.0);
        Person result = ecoFootprintService.updatePerson(person1.getId(), updatedPerson);

        assertEquals(updatedPerson.getName(), result.getName());
        assertEquals(updatedPerson.getLastName(), result.getLastName());
        assertEquals(updatedPerson.getAge(), result.getAge());
        assertEquals(updatedPerson.getCity(), result.getCity());
    }

    @Test
    void when_UpdateCarbonFootprint_should_update_carbon_footprint() throws CarbonFootprintNotFoundException {
        when(carbonFootprintRepository.findById(carbonFootprint1.getId())).thenReturn(Optional.of(carbonFootprint1));

        CarbonFootprint updatedCarbonFootprint = new CarbonFootprint(3.0, 3.0, 3.0, 3.0, person1);
        CarbonFootprint result = ecoFootprintService.updateCarbonFootprint(carbonFootprint1.getId(), updatedCarbonFootprint);

        assertEquals(updatedCarbonFootprint.getTransport(), result.getTransport());
        assertEquals(updatedCarbonFootprint.getEnergy(), result.getEnergy());
        assertEquals(updatedCarbonFootprint.getFood(), result.getFood());
        assertEquals(updatedCarbonFootprint.getOther(), result.getOther());
    }
}