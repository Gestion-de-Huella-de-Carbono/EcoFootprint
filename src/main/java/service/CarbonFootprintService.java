package service;

import data.CarbonFootprint;
import exception.carbonFootprint.CarbonFootprintException;
import exception.carbonFootprint.SavingCarbonFootprintException;
import repository.CarbonFootprintRepository;

import java.util.List;
import java.util.Optional;

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

    public CarbonFootprint save(CarbonFootprint carbonFootprint) throws SavingCarbonFootprintException {
        Optional<CarbonFootprint> optionalCarbonFootprint = carbonFootprintRepository.save(carbonFootprint);

        return  optionalCarbonFootprint.orElseThrow(() -> new SavingCarbonFootprintException( carbonFootprint ));

    }




}
