package data;

public class CarbonFootprint {
private Double transport;
private Double energy;
private Double food;
private Double other;

    public CarbonFootprint(Double transport,Double energy, Double food, Double other) {
        this.transport = transport;
        this.energy = energy;
        this.food = food;
        this.other = other;

    }

    public double getTotalCarbonFootprint() {
        return transport + energy + food + other;
    }

}



