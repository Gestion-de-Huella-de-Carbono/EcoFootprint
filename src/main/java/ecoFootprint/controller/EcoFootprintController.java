package ecoFootprint.controller;

import ecoFootprint.model.CarbonFootprint;
import ecoFootprint.model.Person;
import ecoFootprint.service.EcoFootprintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EcoFootprintController {

    //TODO -Porfavor no tocar
    private EcoFootprintService ecoFootprintService;

    private final Logger logger = LoggerFactory.getLogger(EcoFootprintController.class);


    @GetMapping("/EcoFootprint/persons")
    public ResponseEntity<List<Person>> findAllPersons(){
        logger.info("Find all the videos in Eco Footprint");
        return ResponseEntity.ok().body(ecoFootprintService.findAllPersons());
    }

    @GetMapping("/EcoFootprint/carbonFootprint")
    public ResponseEntity<List<CarbonFootprint>> findAllCarbonFootprintData(){
        logger.info("Find all the carbon footprints in Eco Footprint");
        return ResponseEntity.ok().body(ecoFootprintService.findAllCarbonFootprintData());
    }

    @GetMapping("/EcoFootprint/persons/")
    public ResponseEntity<List<Person>> showSameAgePeople(@RequestParam int age){
        logger.info("find all people with the same age {}:",age);
        return ResponseEntity.ok().body(ecoFootprintService.showSameAgePeople(age));
    }
}
