package ru.reybos.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.reybos.forum.model.Post;
import ru.reybos.forum.model.User;
import ru.reybos.forum.service.PostService;
import ru.reybos.forum.service.UserService;

@Controller
public class PostControl {
    private final PostService postService;
    private final UserService userService;

    public PostControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/post/view")
    public String view(@RequestParam("id") int id, Model model) {
        Post post = postService.findById(id).get();
        model.addAttribute("post", post);
        return "post/view";
    }

    @GetMapping("/post/create")
    public String create(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "post/form";
    }

    @GetMapping("/post/update")
    public String update(@RequestParam("id") int id, Model model) {
        Post post = postService.findById(id).get();
        model.addAttribute("post", post);
        return "post/form";
    }

    @GetMapping("/post/delete")
    public String delete(@RequestParam("id") int id) {
        postService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/post/save")
    public String save(@ModelAttribute Post post) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        User curUser = userService.findByUsername(username);
        post.setUser(curUser);
        postService.save(post);
        return "redirect:/";
    }
}
