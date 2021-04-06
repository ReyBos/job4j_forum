package ru.reybos.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.reybos.forum.model.Post;
import ru.reybos.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
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
        postService.save(post);
        return "redirect:/";
    }
}
