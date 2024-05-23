package ecoFootprint.model;

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

    }// Método para calcular la huella de carbono total
    public double getTotalCarbonFootprint() {
        // Suma los valores de transporte, energía, alimentos y otros para obtener la huella de carbono total
        return transport + energy + food + other;
    }
}



