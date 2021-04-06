package ru.reybos.forum.service;

import org.springframework.stereotype.Service;
import ru.reybos.forum.repository.mem.PostRepository;
import ru.reybos.forum.model.Post;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.postRepository.save(
                Post.of("Продам гараж", new GregorianCalendar(), "вместительный, теплый")
        );
        this.postRepository.save(
                Post.of("Продам машину", new GregorianCalendar(), "не бита, не крашена")
        );
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>(postRepository.findAll());
        return posts;
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }
}