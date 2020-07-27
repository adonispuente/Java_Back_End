package com.lambda.plantdata.services;

import com.lambda.plantdata.models.Plant;

import java.util.List;

public interface PlantService {

    List<Plant> findAll();

    List<Plant> findPlantByNameIgnoringCase(String name);

    Plant save(Plant plant);

    Plant update(Plant plant);

    public void deleteAll();

    public void deleteById(long id);




}
