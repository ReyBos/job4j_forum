package ru.reybos.forum.service;

import org.springframework.stereotype.Service;
import ru.reybos.forum.model.Comment;
import ru.reybos.forum.repository.db.CommentRepository;
import ru.reybos.forum.repository.db.PostRepository;

import javax.transaction.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
