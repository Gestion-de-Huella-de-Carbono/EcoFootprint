package repository.Impl;

import data.Person;
import repository.PersonRepository;
import utils.PersonConstants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PersonFileBased implements PersonRepository {

    @Override
    public List<Person> findAll() {
        // Obtiene la ruta del archivo donde están los datos de personas
        Path path = Paths.get(PersonConstants.PERSON_DATA_PATH);
        try (Stream<String> stream = Files.lines(path)) {// Abre un flujo de líneas desde el archivo
            return stream.map( this::build ).toList(); // Mapea cada línea del archivo a un objeto Person y los recolecta en una lista
        } catch (IOException e) {
            throw new RuntimeException(e);// Lanza una excepción de tiempo de ejecución en caso de error
        }
    }

    private Person build(String text){ // Método para construir un objeto Person a partir de una línea de texto
        // Divide la línea de texto en un arreglo usando la coma como delimitador
        String[] personArray = text.split( "," );

        // Extrae los valores del arreglo y los asigna a variables
        String value1 = personArray[0].trim();
        String value2 = personArray[1].trim();
        int value3 = Integer.parseInt(personArray[2].trim());
        String value4 = personArray[3].trim();
        double value5 = Double.parseDouble(personArray[4].trim());

        // Crea y devuelve un nuevo objeto Person con los valores obtenidos
        return new Person(value1,value2,value3,value4,value5);
    }


    @Override
    public List<Person> showSameAgePeople(List<Person> personList, int age) { // Método para buscar a las personas de una misma edad

        List<Person> peopleWithSameAge = new ArrayList<>(); // creamos un arrayList para almacenar esas personas

        // Recorremos la lista proporcionada con todas las personas
        for (Person persona : personList) {
            if (persona.getAge() == age) {
                // si la edad coincide, agregamos la persona a la lista creada con anterioridad
                peopleWithSameAge.add(persona);
            }
        }
        return peopleWithSameAge;
    }

    @Override
    public void save(String fileAddress, List<Person> persons) throws IOException { // Método para guardar elementos de un ArrayList en un archivo plano
        //creamos un escritor de archivos
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileAddress));

        // cliclo para ecribir cada elemento del ArratList en una nueva linea en el archibo
        for (Person person : persons) {
            bw.write(person.toString());
            bw.newLine();
        }
        // Cerramos el BufferedWriter
        bw.close();
    }
}
