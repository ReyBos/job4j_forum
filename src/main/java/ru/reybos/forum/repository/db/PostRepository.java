package ru.reybos.forum.repository.db;

import org.springframework.data.repository.CrudRepository;
import ru.reybos.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> { }