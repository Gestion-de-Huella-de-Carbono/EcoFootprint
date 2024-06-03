package ecoFootprint.model;

import jakarta.persistence.*;

import java.text.MessageFormat;

@Entity
public class CarbonFootprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double transport;
    private Double energy;
    private Double food;
    private Double other;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public CarbonFootprint(Double transport, Double energy, Double food, Double other, Person person) {
        this.transport = transport;
        this.energy = energy;
        this.food = food;
        this.other = other;
        this.person = person;
    }

    public CarbonFootprint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long code) {
        this.id = code;
    }

    public Double getTransport() {
        return transport;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getFood() {
        return food;
    }

    public void setFood(Double food) {
        this.food = food;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public double getTotalCarbonFootprint() {
        return transport + energy + food + other;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0},{1},{2},{3},{4}",id,transport,energy,food,other);
    }
}
