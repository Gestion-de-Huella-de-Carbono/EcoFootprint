package ecoFootprint.controller;

import ecoFootprint.exception.CarbonFootprintNotFoundException;
import ecoFootprint.exception.PersonNotFoundException;
import ecoFootprint.model.CarbonFootprint;
import ecoFootprint.model.Person;
import ecoFootprint.service.EcoFootprintService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eco-footprint")
public class EcoFootprintController {

    @Autowired
    private EcoFootprintService ecoFootprintService;
    private static final Logger logger = LoggerFactory.getLogger(EcoFootprintController.class);

    @GetMapping("/persons")//ya
    public ResponseEntity<List<Person>> findAllPersons() {
        logger.info("Finding all persons");
        List<Person> persons = ecoFootprintService.findAllPersons();
        return ResponseEntity.ok().body(persons);
    }

    @GetMapping("/persons/age")//ya
    public ResponseEntity<List<Person>> showSameAgePeople(@RequestParam("age") int age) {
        logger.info("Finding persons with age: {}", age);
        List<Person> persons = ecoFootprintService.showSameAgePeople(age);
        return ResponseEntity.ok().body(persons);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) throws PersonNotFoundException {
        Person person = ecoFootprintService.getPersonById(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/carbon-footprints/{personId}")
    public ResponseEntity<CarbonFootprint> getCarbonFootprintByPersonId(@PathVariable Long personId) throws CarbonFootprintNotFoundException {
        logger.info("Getting carbon footprint for person with id: {}", personId);
        CarbonFootprint carbonFootprint = ecoFootprintService.getCarbonFootprintByPersonId(personId);
        return ResponseEntity.ok().body(carbonFootprint);
    }

    @GetMapping("/persons/age-range")
    public ResponseEntity<List<Person>> findPersonsBetweenAges(@RequestParam("minAge") int minAge,
                                                               @RequestParam("maxAge") int maxAge) {
        logger.info("Finding persons between ages: {} and {}", minAge, maxAge);
        List<Person> persons = ecoFootprintService.findByAgeBetween(minAge, maxAge);
        return ResponseEntity.ok().body(persons);
    }

    @GetMapping("/persons/city")//ya
    public ResponseEntity<List<Person>> findByCity(@RequestParam("city") String city) {
        logger.info("Finding persons by city: {}", city);
        List<Person> persons = ecoFootprintService.findByCity(city);
        return ResponseEntity.ok().body(persons);
    }

    @GetMapping("/persons/name")//ya
    public ResponseEntity<List<Person>> findByName(@RequestParam("name") String name) {
        logger.info("Finding persons by name: {}", name);
        List<Person> persons = ecoFootprintService.findByName(name);
        return ResponseEntity.ok().body(persons);
    }

    @PostMapping("/persons")//ya
    public ResponseEntity<Person> savePerson(@RequestBody @Valid Person person) throws PersonNotFoundException {
        logger.info("Saving a new person: {}", person);
        Person savedPerson = ecoFootprintService.savePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @PostMapping("/carbon-footprints")//ya
    public ResponseEntity<CarbonFootprint> saveCarbonFootprint(@RequestBody @Valid CarbonFootprint carbonFootprint) {
        logger.info("Saving a new carbon footprint: {}", carbonFootprint);
        CarbonFootprint savedCarbonFootprint = ecoFootprintService.saveCarbonFootprint(carbonFootprint);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarbonFootprint);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody @Valid Person updatedPerson) throws PersonNotFoundException {
        logger.info("Updating person with id {}: {}", id, updatedPerson);
        Person person = ecoFootprintService.updatePerson(id, updatedPerson);
        return ResponseEntity.ok().body(person);
    }

    @PutMapping("/carbon-footprints/{id}")
    public ResponseEntity<CarbonFootprint> updateCarbonFootprint(@PathVariable Long id, @RequestBody @Valid CarbonFootprint updatedCarbonFootprint) throws CarbonFootprintNotFoundException {
        logger.info("Updating carbon footprint with id {}: {}", id, updatedCarbonFootprint);
        CarbonFootprint carbonFootprint = ecoFootprintService.updateCarbonFootprint(id, updatedCarbonFootprint);
        return ResponseEntity.ok().body(carbonFootprint);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long id) throws PersonNotFoundException{
        logger.info("Deleting person with id: {}", id);
        ecoFootprintService.deletePersonById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/carbon-footprints/{personId}")
    public ResponseEntity<Void> deleteCarbonFootprintByPersonId(@PathVariable Long personId) throws CarbonFootprintNotFoundException {
        logger.info("Deleting carbon footprint for person with id: {}", personId);
        ecoFootprintService.deleteCarbonFootprintByPersonId(personId);
        return ResponseEntity.noContent().build();
    }
}