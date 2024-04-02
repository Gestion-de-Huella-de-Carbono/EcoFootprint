package repository.PersonImpl;

import data.Person;
import repository.PersonRepository;
import utils.FileUtils;
import utils.PersonConstants;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public Optional<Person> save(Person person) {

        Path path = Paths.get(FileUtils.generatePersonPath(person));

        String content = FileUtils.personToText(person);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(person);
    }
}
