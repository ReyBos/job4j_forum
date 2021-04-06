package ru.reybos.forum.repository.db;

import org.springframework.data.repository.CrudRepository;
import ru.reybos.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}