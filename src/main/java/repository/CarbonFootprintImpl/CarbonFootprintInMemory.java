package repository.CarbonFootprintImpl;

import data.CarbonFootprint;
import repository.CarbonFootprintRepository;

import java.util.List;
import java.util.Optional;

public class CarbonFootprintInMemory implements CarbonFootprintRepository {

    private List<CarbonFootprint> carbonFootprintList;
    @Override
    public List<CarbonFootprint> findAll() {
        return carbonFootprintList;
    }

    @Override
    public Optional<CarbonFootprint> save(CarbonFootprint carbonFootprint) {
        boolean result = carbonFootprintList.add(carbonFootprint);

        if(result){
            return Optional.of(carbonFootprint);
        }
        return  Optional.empty();
    }
}
