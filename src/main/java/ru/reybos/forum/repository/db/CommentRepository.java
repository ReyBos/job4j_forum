package ru.reybos.forum.repository.db;

import org.springframework.data.repository.CrudRepository;
import ru.reybos.forum.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> { }