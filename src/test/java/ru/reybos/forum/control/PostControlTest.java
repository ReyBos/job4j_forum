package ru.reybos.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.reybos.forum.Main;
import ru.reybos.forum.model.Post;
import ru.reybos.forum.service.PostService;

import java.util.GregorianCalendar;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    @WithMockUser
    public void whenPostViewThenOk() throws Exception {
        Post post = Post.of("name", new GregorianCalendar(), "description");
        Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(Optional.of(post));
        this.mockMvc.perform(get("/post/view?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/view"));
    }

    @Test
    @WithMockUser
    public void whenCreatePostThenOk() throws Exception {
        this.mockMvc.perform(get("/post/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/form"));
    }

    @Test
    @WithMockUser
    public void whenPostUpdateThenOk() throws Exception {
        Post post = Post.of("name", new GregorianCalendar(), "description");
        Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(Optional.of(post));
        this.mockMvc.perform(get("/post/update?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/form"));
    }

    @Test
    @WithMockUser
    public void whenDeletePostThenRedirect() throws Exception {
        this.mockMvc.perform(get("/post/delete?id=1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}