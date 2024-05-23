package ecoFootprint.repository;

import ecoFootprint.model.CarbonFootprint;

import java.util.List;

public interface CarbonFootprintRepository {

    List<CarbonFootprint> findAll();
}
