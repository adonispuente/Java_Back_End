package com.lambda.plantdata.services;

import com.lambda.plantdata.exceptions.ResourceNotFoundException;
import com.lambda.plantdata.models.*;
import com.lambda.plantdata.repository.RoleRepository;
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

    @Autowired
    private RoleService roleService;


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
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userRepository.findById(user.getUserid())
                    .orElseThrow(() -> new ResourceNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail().toLowerCase());
        newUser.setFirstname(user.getFirstname().toLowerCase());
        newUser.setLastname(user.getLastname().toLowerCase());
        newUser.setPhone(user.getPhone());


//        newUser.getRoles().clear();
//        for (UserRoles ur : user.getRoles())
//        {
//            Role addRole = roleService.findRoleById(ur.getRole()
//                    .getRoleid());
//            newUser.getRoles()
//                    .add(new UserRoles(newUser, addRole));
//        }

        newUser.getPlants().clear();
        for(UserPlants up: user.getPlants())
        {
            newUser.getPlants().add(new UserPlants(newUser,up.getPlants()));
        }


        return userRepository.save(newUser);
    }
    @Transactional
    @Override
    public User update(User user, long id) {

        User currentUser = findUserById(id);

        if (user.getUsername() != null)
        {
            currentUser.setUsername(user.getUsername());
        }

        if (user.getPassword() != null)
        {
            currentUser.setPasswordNoEncrypt(user.getPassword());
        }

        if (user.getPrimaryemail() != null)
        {
            currentUser.setPrimaryemail(user.getPrimaryemail()
                    .toLowerCase());
        }
        if (user.getFirstname() != null)
        {
            currentUser.setFirstname(user.getFirstname());
        }
        if (user.getLastname() != null)
        {
            currentUser.setLastname(user.getLastname());
        }
        if (user.getPhone() != null)
        {
            currentUser.setPhone(user.getPhone());
        }

        if (user.getPlants().size() > 0)
        {
            currentUser.getPlants().clear();
            for (UserPlants ue : user.getPlants())
            {
                currentUser.getPlants().add(new UserPlants(currentUser, ue.getPlants()));
            }
        }

        return userRepository.save(currentUser);
    }

    @Override
    public void deleteAll() {
    userRepository.deleteAll();
    }
}
