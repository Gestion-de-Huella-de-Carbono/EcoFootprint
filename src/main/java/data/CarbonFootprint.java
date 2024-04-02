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

    public Double getTransport() {
        return transport;
    }

    public Double getEnergy() {
        return energy;
    }

    public Double getFood() {
        return food;
    }

    public Double Other() {
        return other;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public void setEnergy(Double energy) {
         this.energy = energy;
    }

    public void setFood(Double food) {
        this.food = food;
    }

    public void setOther(Double other) {
        this.other = other;
    }


}
 /*
    =======




    // agregar el metodo para que se sume toda la contaminacion y retorne el total


    public double getTotalCarbonFootprint() {
        return transportation + energy + food + others;
    }


>>>>>>> origin/main*/