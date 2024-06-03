package ecoFootprint.exception;

import java.text.MessageFormat;

public class CarbonFootprintNotFoundException extends EcoFootprintException {
    public CarbonFootprintNotFoundException() {
        super("Carbon footprint not found");
    }

    public CarbonFootprintNotFoundException(Long code) {
        super(MessageFormat.format("Carbon footprint not found: Code {0}", code));
    }
}

