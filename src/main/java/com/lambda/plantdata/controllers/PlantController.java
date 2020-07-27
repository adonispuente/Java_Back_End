package com.lambda.plantdata.controllers;

import com.lambda.plantdata.models.Plant;
import com.lambda.plantdata.models.User;
import com.lambda.plantdata.models.UserPlants;
import com.lambda.plantdata.services.PlantService;
import com.lambda.plantdata.services.UserService;
import org.h2.table.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlantController {

    @Autowired
    UserService userService;

    @Autowired
    PlantService plantService;

    // http://localhost:2019/plants/
    @GetMapping(value = "/plants", produces = {"application/json"})
    public ResponseEntity<?> listAllPlants(HttpServletRequest request)
    {
        List<Plant> myPlants = plantService.findAll();
        return new ResponseEntity<>(myPlants, HttpStatus.OK);
    }



}
