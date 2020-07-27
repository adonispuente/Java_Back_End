package com.lambda.plantdata.services;


import com.lambda.plantdata.exceptions.ResourceNotFoundException;
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

        return plantRepository.save(plant);
    }

    @Transactional
    @Override
    public Plant update(Plant plant,long id) {

    Plant currentPlant = findPlantById(id);

    if(plant.getImage()!=null)
    {
        currentPlant.setImage(plant.getImage());
    }
    if (plant.getName()!=null)
    {
        currentPlant.setName(plant.getName());
    }
    if (plant.getSpecies()!=null)
        {
            currentPlant.setSpecies(plant.getSpecies());
        }
    if (plant.getWater_frequency()!=null)
        {
            currentPlant.setWater_frequency(plant.getWater_frequency());
        }

        return plantRepository.save(currentPlant);
    }
    @Override
    public Plant findPlantById(long id)
    {
        return plantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plant with id " + id + " Not Found!"));
    }


    @Override
    public void deleteAll() {
        plantRepository.deleteAll();
    }

    @Override
    public void deleteById(long id) {

        {
            if (plantRepository.findById(id)
                    .isPresent())
            {
                plantRepository.deleteById(id);
            } else
            {
                throw new ResourceNotFoundException("Plant with id " + id + " Not Found!");
            }
        }
    }
}
