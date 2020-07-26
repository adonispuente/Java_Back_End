package com.lambda.plantdata.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantid;


    private String name;
    private String water_frequency;
    private String species;
    private String image;

    @ManyToOne
    @JoinColumn(name ="userid", nullable = false)
    @JsonIgnoreProperties(value = "plants", allowSetters = true)
    private User user;

    public Plant() {
    }

    public Plant(String name, String water_frequency, String species, String image) {
        this.name = name;
        this.water_frequency = water_frequency;
        this.species = species;
        this.image = image;
    }

    public long getPlantid() {
        return plantid;
    }

    public void setPlantid(long plantid) {
        this.plantid = plantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWater_frequency() {
        return water_frequency;
    }

    public void setWater_frequency(String water_frequency) {
        this.water_frequency = water_frequency;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "plantid=" + plantid +
                ", name='" + name + '\'' +
                ", water_frequency='" + water_frequency + '\'' +
                ", species='" + species + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
