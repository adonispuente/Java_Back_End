package com.lambda.plantdata.models;

import java.io.Serializable;
import java.util.Objects;

public class UserPlantsId implements Serializable
{

    /**
     * The id of the user
     */
    private long user;

    /**
     * The id of the plant
     */
    private long plants;

    public UserPlantsId() {
    }


    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getPlant() {
        return plants;
    }

    public void setPlant(long plant) {
        this.plants = plant;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        UserPlantsId that = (UserPlantsId) o;
        return user == that.user &&
                plants == that.plants;
    }

    @Override
    public int hashCode() {
        return 37;
    }
}
