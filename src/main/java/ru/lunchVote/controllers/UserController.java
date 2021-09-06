package ru.lunchVote.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.lunchVote.models.User;
import ru.lunchVote.service.UserService;

import java.util.List;

// Sweets
@Tag(name = "Users", description = "Users API, Can only be used by admins")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Get user for id")
    @GetMapping("/{userId}")
    public User get(@PathVariable("userId") int userId){
        return userService.getUser(userId);
    }

    @Operation(summary = "Gets all users")
    @GetMapping("")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @Operation(summary = "Create User", description = "Request and response in JSON")
    @PostMapping("")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @Operation(summary = "Update User", description = "Request and response in JSON")
    @PatchMapping("")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @Operation(summary = "Delete User")
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") int userId){
        userService.delete(userId);
    }

}
