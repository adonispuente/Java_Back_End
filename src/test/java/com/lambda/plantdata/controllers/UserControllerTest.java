package com.lambda.plantdata.controllers;

import com.lambda.plantdata.PlantdataApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlantdataApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllUsers() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void addNewPlanttoUser() {
    }

    @Test
    public void deleteUserPlantById() {
    }

    @Test
    public void updateFullUser() {
    }

    @Test
    public void myInfo() {
    }

    @Test
    public void updateUserPlants() {
    }
}