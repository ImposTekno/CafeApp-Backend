package com.ImposTekno.CafeApp.Service;

import com.ImposTekno.CafeApp.CustomExceptions.ModelNotFoundException;
import com.ImposTekno.CafeApp.Model.User;
import com.ImposTekno.CafeApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User newUser)
    {
        // Adding a new user to a database
        return userRepo.save(newUser);
    }

    public List<User> findAllUsers()
    {
        // Getting all users from a database
        return userRepo.findAll();
    }

    public User updateUser(User updateUser)
    {
        // Updating an existing user with specified changes
        return userRepo.save(updateUser);
    }

    public void deleteUser(Long _id)
    {
        // Delete the user with specified id
        userRepo.deleteUserById(_id);
    }

    public User findUserById(Long _id)
    {
        // Getting specific user by his/hers id
        return userRepo.findUserById(_id).orElseThrow(()-> new ModelNotFoundException("User was not found by specified id: " + _id));
    }

    public User findUserByName(String _name)
    {
        // Getting specific user by his/hers username
        return userRepo.findUserByfirstName(_name).orElseThrow(()-> new ModelNotFoundException("User was not found by specified name: " + _name));
    }

}
