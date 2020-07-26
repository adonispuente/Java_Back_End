package com.lambda.plantdata.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userplants")
@IdClass(UserPlantsId.class)
public class UserPlants extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "plants", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "plantid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Plant plant;

    public UserPlants() {
    }

    public UserPlants(User user, Plant plant) {
        this.user = user;
        this.plant = plant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }


    @Override
    public int hashCode() {
        return 37;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserPlants))
        {
            return false;
        }
        UserPlants that = (UserPlants) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
                ((plant == null) ? 0 : plant.getPlantid()) == ((that.plant == null) ? 0 : that.plant.getPlantid());
    }
}
