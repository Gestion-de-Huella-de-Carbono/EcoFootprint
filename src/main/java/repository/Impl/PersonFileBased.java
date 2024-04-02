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

        Path path = Paths.get(PersonConstants.PERSON_DATA_PATH);
        try (Stream<String> stream = Files.lines(path)) {
            return stream.map( this::build ).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Person build(String text){
        String[] personArray = text.split( "," );

        String value1 = personArray[0].trim();
        String value2 = personArray[1].trim();
        int value3 = Integer.parseInt(personArray[2].trim());
        String value4 = personArray[3].trim();
        double value5 = Double.parseDouble(personArray[4].trim());

        return new Person(value1,value2,value3,value4,value5);
    }


    @Override
    public List<Person> showSameAgePeople(List<Person> personList, int age) {

        List<Person> peopleWithSameAge = new ArrayList<>();

        // Recorremos la lista de personas
        for (Person persona : personList) {
            if (persona.getAge() == age) {
                // si la edad coincide, agregamos la persona a la lista de resultados
                peopleWithSameAge.add(persona);
            }
        }
        return peopleWithSameAge;
    }

    @Override
    public void save(String fileAddress, ArrayList<?> arrayList) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileAddress));
        for (Object element : arrayList) {
            bw.write(element.toString());
            bw.newLine();
        }
        bw.close();
    }
}
