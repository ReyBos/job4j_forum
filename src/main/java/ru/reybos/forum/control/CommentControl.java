package ru.reybos.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.reybos.forum.model.Comment;
import ru.reybos.forum.service.CommentService;

@Controller
public class CommentControl {
    private final CommentService commentService;

    public CommentControl(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/save")
    public String save(@ModelAttribute Comment comment, RedirectAttributes attributes) {
        commentService.save(comment);
        attributes.addAttribute("id", comment.getPost().getId());
        return "redirect:/post/view";
    }
}
