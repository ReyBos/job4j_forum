package ru.reybos.forum.service;

import org.springframework.stereotype.Service;
import ru.reybos.forum.model.User;
import ru.reybos.forum.repository.db.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
