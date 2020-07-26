package com.lambda.plantdata.repository;

import com.lambda.plantdata.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {


    User findByUsername(String name);


    List<User> findByUsernameContainingIgnoreCase(String name);

}
