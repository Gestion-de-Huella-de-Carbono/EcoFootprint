package repository;

import data.CarbonFootprint;

import java.util.List;
import java.util.Optional;

public interface CarbonFootprintRepository {

    List<CarbonFootprint> findAll();

    default Optional<CarbonFootprint> save(CarbonFootprint carbonFootprint){
        return null;
    }
}
