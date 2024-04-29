package com.apex.copilotapi.controller;

import com.apex.copilotapi.entities.Users;
import com.apex.copilotapi.repositories.UsersRepository;
import com.apex.copilotapi.requests.UserRequest;
import com.apex.copilotapi.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all users", notes = "Get all users from the database")
    @GetMapping(value = "/users")
    public @ResponseBody Iterable getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{id}")
    public @ResponseBody Users getUser(@PathVariable final long id){
        return userService.getUser(id);
    }

    @PostMapping(value = "/user")
    public @ResponseBody void addUser(@RequestBody final UserRequest user){
        userService.addUser(user);
    }

    @PutMapping(value = "/user/{id}")
    public @ResponseBody void editUser(@PathVariable final long id, @RequestBody final UserRequest user){
        userService.editUser(id, user);
    }

    @DeleteMapping(value = "/user/{id}")
    public @ResponseBody void deleteUser(@PathVariable final long id){
        userService.deleteUser(id);
    }



}
