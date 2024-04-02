import data.CarbonFootprint;
import data.Person;
import exception.carbonFootprint.CarbonFootprintException;
import exception.person.PersonException;
import repository.Impl.CarbonFootprintFileBased;
import repository.Impl.PersonFileBased;
import service.CarbonFootprintService;
import service.PersonService;
import java.util.ArrayList;
import java.util.List;

public class ApplicacionRunner {
    public static void main(String[] args) throws PersonException, CarbonFootprintException {

        PersonService personService = new PersonService(new PersonFileBased());
        CarbonFootprintService carbonFootprintService = new CarbonFootprintService(new CarbonFootprintFileBased());

        // Aqui se lista todas las personas
        List<Person> personList = personService.findAll();
        ArrayList<Person> arrayListPerson = new ArrayList<>(personList); // convertimos la lista a un arraylist


        // aqui se lista todos los datos de la Huella de carbono
        List<CarbonFootprint> carbonFootprintList = carbonFootprintService.findAll();
        ArrayList<CarbonFootprint> arrayListCarbonFootprint = new ArrayList<>(carbonFootprintList); // convertimos la lista a un arraylist

        // Calcular la suma total de la huella de carbono por persona
        for (int i = 0; i < arrayListPerson.size(); i++) {
            arrayListPerson.get(i).setTotalCarbonFootprint(arrayListCarbonFootprint.get(i).getTotalCarbonFootprint());
        }

        // Imprimir la lista de personas con la huella de carbono total actualizada
        for (Person person : arrayListPerson) {
            System.out.println(person.toString());
        }


        // busqueda por edad
        List<Person> listPeopleSameAge = personService.showSameAgePeople(arrayListPerson,20);

        System.out.println("Personas de 20 años:");
        for (Person persona : listPeopleSameAge) {
            System.out.println(listPeopleSameAge);
        }


        // creamos y agregamos al arraylisst una nueva persona
        var carbonFootprint = new CarbonFootprint(234.2,132.1,45.6,2.1);
        var person = new Person("yeferon", "salcedo", 20,"taraza",carbonFootprint.getTotalCarbonFootprint());
        arrayListPerson.add(person);

        // creamos un nuevo archivo plano para guardar la lista de personas actualizadas
        personService.save("./src/main/resources/person_Result", arrayListPerson);

    }
}