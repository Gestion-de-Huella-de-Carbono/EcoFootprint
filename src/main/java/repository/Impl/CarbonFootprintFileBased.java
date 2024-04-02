package repository.Impl;

import data.CarbonFootprint;
import repository.CarbonFootprintRepository;
import utils.CarbonFootprintConstants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CarbonFootprintFileBased implements CarbonFootprintRepository {
    @Override
    public List<CarbonFootprint> findAll() {

        Path path = Paths.get(CarbonFootprintConstants.CARBONFOOTPRINT_DATA_PATH);
        try(Stream<String> stream = Files.lines(path)){
            return stream.map( this::build ).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CarbonFootprint build(String text) {
        String[] carbonFootprintArray = text.split(",");

        double value1 = Double.parseDouble(carbonFootprintArray[0].trim());
        double value2 = Double.parseDouble(carbonFootprintArray[1].trim());
        double value3 = Double.parseDouble(carbonFootprintArray[2].trim());
        double value4 = Double.parseDouble(carbonFootprintArray[3].trim());

        return new CarbonFootprint(value1, value2, value3, value4);
    }

}
