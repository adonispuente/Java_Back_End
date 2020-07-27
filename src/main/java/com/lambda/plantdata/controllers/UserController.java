package com.lambda.plantdata.controllers;

import com.lambda.plantdata.models.*;
import com.lambda.plantdata.services.PlantService;
import com.lambda.plantdata.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PlantService plantService;

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> listAllUsers()
    {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User newuser) throws URISyntaxException
    {
        newuser.setUserid(0);
        Role r2 = new Role("USER");
        newuser.getRoles().add( new UserRoles(newuser,r2));

        newuser = userService.save(newuser);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // POST http://localhost:2019/plants
    @PostMapping(value = "/plants/{userid}", consumes = "application/json")
    public ResponseEntity<?> addNewPlanttoUser(@Valid @RequestBody Plant newPlant, @PathVariable long userid) throws
            URISyntaxException
    {
        newPlant.setPlantid(0);

        User myUser = userService.findUserById(userid);
        myUser.getPlants().add(new UserPlants(myUser,newPlant));

        plantService.save(newPlant);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPlantURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{plantid}")
                .buildAndExpand(newPlant.getPlantid())
                .toUri();
        responseHeaders.setLocation(newPlantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/plants/{plantid}")
    public ResponseEntity<?> deleteUserPlantById(@PathVariable long plantid)
    {
        plantService.deleteById(plantid);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
