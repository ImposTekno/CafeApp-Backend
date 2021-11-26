package com.ImposTekno.CafeApp.Controllers;

import com.ImposTekno.CafeApp.Model.User;
import com.ImposTekno.CafeApp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<User> getUserById(@PathVariable("name") String name)
    {
        User user = userService.findUserByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User _user)
    {
        User user = userService.addUser(_user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
