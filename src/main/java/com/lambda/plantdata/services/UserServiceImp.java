package com.lambda.plantdata.services;

import com.lambda.plantdata.exceptions.ResourceNotFoundException;
import com.lambda.plantdata.models.User;
import com.lambda.plantdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service(value = "userService")
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;




    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        userRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<User> findByNameContaining(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username.toLowerCase());
    }

    @Override
    public User findUserById(long id) throws
            ResourceNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public User findByName(String name) {
        User uu = userRepository.findByUsername(name.toLowerCase());
        if (uu == null)
        {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Override
    public void delete(long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user, long id) {
        return null;
    }

    @Override
    public void deleteAll() {
    userRepository.deleteAll();
    }
}
