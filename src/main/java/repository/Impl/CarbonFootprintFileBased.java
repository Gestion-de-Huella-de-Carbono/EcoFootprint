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
    @Override // Método para obtener todos los datos de huella de carbono del archivo
    public List<CarbonFootprint> findAll() {
        // Obtiene la ruta del archivo donde están los datos de huella de carbono
        Path path = Paths.get(CarbonFootprintConstants.CARBONFOOTPRINT_DATA_PATH);

        try(Stream<String> stream = Files.lines(path)){ // Abre un flujo de líneas desde el archivo
            return stream.map( this::build ).toList(); // Mapea cada línea del archivo a un objeto CarbonFootprint y los recolecta en una lista
        } catch (IOException e) {
            throw new RuntimeException(e); // Lanza una excepción de tiempo de ejecución en caso de error

        }
    }

    private CarbonFootprint build(String text) { // Método para construir un objeto CarbonFootprint a partir de una línea de texto
        // Divide la línea de texto en un arreglo usando la coma como delimitador
        String[] carbonFootprintArray = text.split(",");

        // Convierte cada valor del arreglo a double y los asigna a variables
        double value1 = Double.parseDouble(carbonFootprintArray[0].trim());
        double value2 = Double.parseDouble(carbonFootprintArray[1].trim());
        double value3 = Double.parseDouble(carbonFootprintArray[2].trim());
        double value4 = Double.parseDouble(carbonFootprintArray[3].trim());

        // Crea y devuelve un nuevo objeto CarbonFootprint con los valores obtenidos
        return new CarbonFootprint(value1, value2, value3, value4);
    }

}
