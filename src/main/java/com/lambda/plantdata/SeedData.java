package com.lambda.plantdata;

import com.lambda.plantdata.models.*;
import com.lambda.plantdata.services.PlantService;
import com.lambda.plantdata.services.RoleService;
import com.lambda.plantdata.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Email;

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


        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");
        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

//        (String name, String water_frequency, String species, String image)
        Plant p1 = new Plant("LilyPad","Once a week","Marine","n/a");
        Plant p2 = new Plant("boogerplant","twice a week","Marine","n/a");
        Plant p3 = new Plant("lionplant","Once a year","Marine","n/a");
        Plant p4 = new Plant("supermonsterplantthateaatskidswhomisbehave","Never, feeds off bad kids","Marine","n/a");
        plantService.save(p1);
        plantService.save(p2);
        plantService.save(p3);
        plantService.save(p4);
//        public User(String username, String password, @Email String primaryemail, String firstname, String lastname,
//        String phone, Set< UserRoles > roles, Set< Plant > plants) {

        User u1 = new User("AdonisP", "Password", "adonis@adonis.com", "Adonis", "Puente","7861231234" );
        u1.getRoles().add(new UserRoles(u1,r1));
        u1.getPlants().add(new UserPlants(u1,p1));
        userService.save(u1);

        User u2 = new User("PABLOP", "Password", "pablo@adonis.com", "pablo", "bobop","123456789" );
        u2.getRoles().add(new UserRoles(u2,r2));
        u2.getPlants().add(new UserPlants(u2,p2));
        userService.save(u2);


        User u3 = new User("MEGAMAN", "Password", "MEGAMAN@adonis.com", "MEGA", "MAN","9999999999" );
        u3.getRoles().add(new UserRoles(u3,r2));
        u3.getPlants().add(new UserPlants(u3,p3));
        userService.save(u3);


        User u4 = new User("PROTOMAN", "Password", "PROTO@adonis.com", "PROTO", "MAN","123456789" );
        u4.getRoles().add(new UserRoles(u4,r2));
        u4.getPlants().add(new UserPlants(u4,p4));
        userService.save(u4);




    }
}
