package com.lambda.plantdata.services;

import com.lambda.plantdata.PlantdataApplication;
import com.lambda.plantdata.exceptions.ResourceFoundException;
import com.lambda.plantdata.exceptions.ResourceNotFoundException;
import com.lambda.plantdata.models.User;
import com.lambda.plantdata.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlantdataApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImpTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        //mocks = fake data
        //stubs -> fake methods
        MockitoAnnotations.initMocks(this);
        List<User> mylist= userService.findAll();
        //print out test data for hehe's and haha's
        for (User u : mylist)
        {
            System.out.println(u.getUsername()+ " " + u.getUserid());
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void afindAll() {
        assertEquals(3,userService.findAll().size());

    }

    @Test
    public void afindByNameContaining() {
        assertEquals(1,userService.findByNameContaining("PABLO").size());

    }

    @Test
    public void afindUserById() {
        assertEquals(9,userService.findUserById(9).getUserid());

    }

    @Test(expected = ResourceNotFoundException.class)
    public void abfindUserByIdFail()
    {
        assertEquals("test eagle cafe", userService.findUserById(99999).getUsername());
    }

    @Test
    public void bfindByName() {
        assertEquals(9,userService.findByName("PABLOP").getUserid());

    }

    @Test(expected = ResourceNotFoundException.class)
    public void bafindByNameNotFound()
    {
        assertEquals("cinnamon", userService.findByName("cinnamon").getUsername());
    }



    @Test
    public void cdelete() {
        userService.delete(10);
        assertEquals(2, userService.findAll().size());
    }

    @Test
    public void csave() {
        Set<UserRoles> thisRole = new HashSet<>();
        User newUser = new User("newguy", "123", "1234@adonis.com", "pablo", "bobop","1233131" );
        User addUser = userService.save(newUser);

        assertNotNull(addUser);
        User foundUser = userService.findUserById(addUser.getUserid());
        assertEquals(addUser.getUsername(), foundUser.getUsername());
    }

    @Test
    public void update() {
    }

    @Test
    public void zdeleteAll() {
        userService.deleteAll();
        assertEquals(0,userService.findAll().size());
    }
}