package repository.CarbonFootprintImpl;

import data.CarbonFootprint;
import repository.CarbonFootprintRepository;
import utils.CarbonFootprintConstants;
import utils.FileUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
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

    private Object build(String text) {
        String[] carbonFootprintArray = text.split(",");
        return new CarbonFootprint(carbonFootprintArray[0].trim(),carbonFootprintArray[1].trim(),carbonFootprintArray[2].trim(),carbonFootprintArray[3].trim());
    }


    public Optional<CarbonFootprint> save(CarbonFootprint carbonFootprint) {

        Path path = Paths.get(FileUtils.generateCarbonFootprintPath(carbonFootprint));

        String content = FileUtils.carbonFootprintToText(carbonFootprint);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(carbonFootprint);
    }
}
