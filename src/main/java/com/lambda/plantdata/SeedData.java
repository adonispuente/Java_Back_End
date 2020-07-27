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
   private UserService userService;
    @Autowired
   private PlantService plantService;
    @Autowired
   private RoleService roleService;
    @Transactional
    @Override
    public void run(String... args) throws Exception {

        userService.deleteAll();
        roleService.deleteAll();
        plantService.deleteAll();


        Role r1 = new Role("ADMIN");
        Role r2 = new Role("USER");
        Role r3 = new Role("DATA");
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


//        created_by, created_date, last_modified_by, last_modified_date, firstname, lastname, password, phone, primaryemail, username, userid)
        User u1 = new User("AP", "PASSWORD", "ADONIS@ADONS.COM", "ADONIS", "PUENTE","7861231234" );
        u1.getRoles().add(new UserRoles(u1,r1));
        u1.getPlants().add(new UserPlants(u1,p1));
        userService.save(u1);






        User u2 = new User("PABLOP", "Password", "pablo@adonis.com", "pablo", "bobop","123456789" );
        u2.getRoles().add(new UserRoles(u2,r2));
        u2.getPlants().add(new UserPlants(u2,p2));
        userService.save(u2);


        User u3 = new User("MEGAMAN", "Password", "MEGAMAN@adonis.com", "MEGA", "MAN","91234141" );
        u3.getRoles().add(new UserRoles(u3,r2));
        u3.getPlants().add(new UserPlants(u3,p3));
        userService.save(u3);


//        User u4 = new User("admin", "password", "admin@lambdaschool.local");
//                u4.getRoles().add(new UserRoles(u4,r3));
//        u4.getPlants().add(new UserPlants(u4,p4));
//        userService.save(u4);

//        for(UserPlants up: u1.getPlants()){
//            System.out.println(up.getPlants() + " LOOOK HERE RIGHT *******************************!!!!!!!!!!!!!!");
//
//        }


    }
}
