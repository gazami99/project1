package com.example.project.controller;

import com.example.project.service.PostService;
import com.example.project.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    public boolean creatPost(@RequestBody PostVo post) {
        return postService.savePost(post);
    }

    @GetMapping("/{id}")
    public Optional<PostVo> getPostById(@PathVariable int id) {
        return postService.selectPost(id);
    }
    @PutMapping("/{id}")
    public void UpdatePostById(@PathVariable int id, @RequestBody PostVo post) {
        postService.updatePost(id,post);
    }
    @GetMapping("/all")
    public List<? extends PostVo> getPostAll() {
        return postService.selectAll();
    }
}
