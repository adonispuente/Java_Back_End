package com.lambda.plantdata.repository;

import com.lambda.plantdata.models.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant,Long> {

    List<Plant> findPlantByNameIgnoringCase(String name);

    Plant save(Plant plant);
}
