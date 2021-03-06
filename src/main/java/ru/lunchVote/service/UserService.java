package ru.lunchVote.service;

import org.springframework.stereotype.Service;
import ru.lunchVote.models.User;
import ru.lunchVote.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


// Sweets
@Service
public class UserService {

    private final UserRepository userRepository;
    private Object User;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User getUser(int id){
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    public User create(User user) {
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return user;
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        userRepository.save(user);
    }
}
