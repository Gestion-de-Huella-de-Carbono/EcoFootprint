package service;

import data.CarbonFootprint;
import exception.carbonFootprint.CarbonFootprintException;
import repository.CarbonFootprintRepository;
import java.util.List;


public class CarbonFootprintService {

    private CarbonFootprintRepository carbonFootprintRepository;

    public CarbonFootprintService(CarbonFootprintRepository carbonFootprintRepository){
        this.carbonFootprintRepository = carbonFootprintRepository;
    }

    public List<CarbonFootprint> findAll() throws CarbonFootprintException{
        var carbonFootprint = carbonFootprintRepository.findAll();

        if(carbonFootprint.isEmpty()){
            throw new CarbonFootprintException();
        }
        return carbonFootprint;
    }
}
