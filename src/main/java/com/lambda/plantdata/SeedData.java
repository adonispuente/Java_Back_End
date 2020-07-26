package com.lambda.plantdata;

import com.lambda.plantdata.services.PlantService;
import com.lambda.plantdata.services.RoleService;
import com.lambda.plantdata.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    PlantService plantService;
    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {

        userService.deleteAll();
        roleService.deleteAll();
        plantService.deleteAll();





    }
}
