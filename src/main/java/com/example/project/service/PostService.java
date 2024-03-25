package com.example.project.service;

import com.example.project.db.InMemory;
import com.example.project.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private InMemory inMemory;

    @Autowired
    public PostService(InMemory inMemory) {
        this.inMemory = inMemory;
    }

    public boolean savePost(PostVo requestPostVo) {
        return inMemory.save(requestPostVo.toBuilder()
                                            .createdTime(LocalDateTime.now())
                                            .build());
    }

    public void updatePost(int num, PostVo requestPostVo) {
        inMemory.select(num).ifPresent(p -> { p.setUpdatedTime(LocalDateTime.now());
                                                p.setTitle(requestPostVo.getTitle());
                                                p.setBody(requestPostVo.getBody());
                                                p.setUserName(requestPostVo.getUserName());
                                                });
    }

    public Optional<PostVo> selectPost(int num) {
        return inMemory.select(num);
    }

    public List<? extends PostVo> selectAll() {
        return inMemory.selectAll();
    }

}
