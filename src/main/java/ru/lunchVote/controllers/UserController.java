package ru.lunchVote.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lunchVote.models.User;
import ru.lunchVote.service.UserService;

import java.util.List;

// Sweets
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User get(@PathVariable("userId") int userId){
        return userService.getUser(userId);
    }

    @GetMapping("")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PatchMapping("")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") int userId){
        userService.delete(userId);
    }

}
