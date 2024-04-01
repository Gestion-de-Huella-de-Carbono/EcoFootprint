import data.CarbonFootprint;
import data.Person;
import exception.carbonFootprint.CarbonFootprintException;
import exception.person.SavingPersonException;
import repository.CarbonFootprintImpl.CarbonFootprintFileBased;
import repository.CarbonFootprintImpl.CarbonFootprintInMemory;
import repository.PersonImpl.PersonFileBased;
import repository.PersonImpl.PersonInMemory;
import repository.PersonRepository;
import service.CarbonFootprintService;
import service.PersonService;

import java.text.ParseException;
import java.util.List;

public class ApplicacionRunner {
    public static void main(String[] args) throws ParseException, CarbonFootprintException {




        //PersonService personService = new PersonService(new PersonInMemory());
        PersonService personService = new PersonService(new PersonFileBased());

        //CarbonFootprintService carbonFootprintService = new CarbonFootprintService(new CarbonFootprintInMemory());
        CarbonFootprintService carbonFootprintService = new CarbonFootprintService(new CarbonFootprintFileBased());

        // Aqui se lista todas las personas
        List<Person> personList = personService.findAll();
        System.out.println(personList);

        // Mostrar las personas con 25 años
        List<Person> person25Age = personService.showSameAgePeople(25);
        for (Person persona : person25Age) {
            System.out.println(persona.getName() + " " + persona.getLastName();
        }

        // aqui se lista todos los datos de la Huella de carbono
        List<CarbonFootprint> carbonFootprintList = carbonFootprintService.findAll();
        System.out.println(carbonFootprintList);

        // aqui se agregan datos de contaminacion de una nueva persona
        var Co2 = new CarbonFootprint(200.6,183.2,43.2,1.2);
        var newCarbonFootprint = carbonFootprintService.save(Co2);
        System.out.println(newCarbonFootprint);



        // aqui se agrega una nueva persona
        var person = new Person("Julian","Perez",20,"medellin",1400);
        Person newPerson = null;
        try {
            newPerson = personService.save(person);
        } catch (SavingPersonException e) {
            throw new RuntimeException(e);
        }

        System.out.println(newPerson);

    }
}
