package ru.lunchVote.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lunchVote.models.User;
import ru.lunchVote.service.UserService;

import java.util.List;

// Sweets
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService us){
        this.userService = us;
    }

    @GetMapping("users/{userId}")
    public User get(@PathVariable("userId") int userId){
        return userService.getUser(userId);
    }

    @GetMapping("users")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("users")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("users")
    public void update(@RequestBody User user){
        userService.update(user, user.getId());
    }

    @DeleteMapping("users/{userId}")
    public void delete(@PathVariable("userId") int userId){
        userService.delete(userId);
    }

}
