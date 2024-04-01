package data;

public class CarbonFootprint {
private Float transport;
private Float energy;
private Float food;
private Float other;


    public CarbonFootprint(Float transport, Float energy, Float food, Float other) {
        this.transport = transport;
        this.energy = energy;
        this.food = food;
        this.other = other;

    }

    public Float getTransport() {
        return transport;
    }

    public Float getEnergy() {
        return energy;
    }

    public Float getFood() {
        return food;
    }

    public Float Other() {
        return other;
    }

    public void setTransport(Float transport) {
        this.transport = transport;
    }

    public void setEnergy(Float energy) {
         this.energy = energy;
    }

    public void setFood(Float food) {
        this.food = food;
    }

    public void setOther(Float other) {
        this.other = other;
    }
}
