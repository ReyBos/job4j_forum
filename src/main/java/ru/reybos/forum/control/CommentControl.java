package ru.reybos.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.reybos.forum.model.Comment;
import ru.reybos.forum.model.User;
import ru.reybos.forum.service.CommentService;
import ru.reybos.forum.service.UserService;

@Controller
public class CommentControl {
    private final CommentService commentService;
    private final UserService userService;

    public CommentControl(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/comment/save")
    public String save(@ModelAttribute Comment comment, RedirectAttributes attributes) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        User curUser = userService.findByUsername(username);
        comment.setUser(curUser);
        commentService.save(comment);
        attributes.addAttribute("id", comment.getPost().getId());
        return "redirect:/post/view";
    }
}
