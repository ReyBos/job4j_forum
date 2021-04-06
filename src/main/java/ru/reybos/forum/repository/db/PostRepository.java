package ru.reybos.forum.repository.db;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ru.reybos.forum.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @EntityGraph(attributePaths = {"user"})
    List<Post> findAll();

    @EntityGraph(attributePaths = {"user", "comments"})
    Optional<Post> findById(int id);
}