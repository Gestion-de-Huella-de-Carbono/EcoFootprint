package utils;

import data.CarbonFootprint;

import java.text.MessageFormat;

public class FileUtils {

    // para Person


    // para CarbonFootprint
    public static String generateCarbonFootprintPath(CarbonFootprint carbonFootprint){
        return MessageFormat.format("./main/resources/CarbonFootPrint_{0}.txt");
    }
    public static String carbonFootprintToText(CarbonFootprint carbonFootprint){
        return MessageFormat.format("{0},{1},{2},{3}");
    }

}
