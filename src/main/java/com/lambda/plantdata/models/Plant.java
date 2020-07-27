package com.lambda.plantdata.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plants")
public class Plant extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String water_frequency;

    @Column(nullable = false)
    private String species;

    private String image;

    @OneToMany
    @JoinColumn(name ="plants", nullable = false)
    @JsonIgnoreProperties(value = "plants", allowSetters = true)
    private Set<UserPlants> users = new HashSet<>();

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

    public Set<UserPlants> getUsers() {
        return users;
    }

    public void setUsers(Set<UserPlants> users) {
        this.users = users;
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
