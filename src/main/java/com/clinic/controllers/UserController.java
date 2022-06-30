package com.clinic.controllers;

import com.clinic.models.User;
import com.clinic.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    @ApiOperation(value = "Function that returns all users", notes = "returns all Users present in the DB")
    public List<User> list() {
        return userService.listAllUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Function that returns user by userId", notes = "returns a User from user_Id")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Function that inserts a single user")
    public void add(@RequestBody User user) {
        userService.saveUser(user);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
//        try {
//            User userExists = userService.getUser(id);
//            user.setUser_id(user.getUser_id());
//            userService.saveUser(user);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Function that deletes a single user")
    public void delete(@PathVariable Integer id) {
        userService.deleteUsers(id);
    }

}