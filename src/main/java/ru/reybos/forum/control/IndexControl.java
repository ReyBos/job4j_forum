package ru.reybos.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.reybos.forum.model.User;
import ru.reybos.forum.service.PostService;
import ru.reybos.forum.service.UserService;

@Controller
public class IndexControl {
    private final PostService posts;
    private final UserService userService;

    public IndexControl(PostService posts, UserService userService) {
        this.posts = posts;
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", posts.findAll());
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        User curUser = userService.findByUsername(username);
        model.addAttribute("userId", curUser.getId());
        return "index";
    }
}