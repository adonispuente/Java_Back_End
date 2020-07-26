package com.lambda.plantdata.services;


import com.lambda.plantdata.models.Plant;
import com.lambda.plantdata.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service(value = "plantService")
public class PlantServiceImp implements PlantService{
    @Autowired
    PlantRepository plantRepository;

    @Override
    public List<Plant> findAll() {
        return null;
    }

    @Override
    public List<Plant> findPlantByNameIgnoringCase(String name) {
        return plantRepository.findPlantByNameIgnoringCase(name.toLowerCase());
    }

    @Override
    public Plant save(Plant plant) {
        return null;
    }

    @Override
    public Plant update(Plant plant) {
        return null;
    }
}
