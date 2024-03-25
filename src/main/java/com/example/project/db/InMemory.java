package com.example.project.db;


import com.example.project.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemory {

    private ArrayList<PostVo> Posts = new ArrayList<>();

    public boolean save(PostVo post) {
        return Posts.add(post);
    }
    public Optional<PostVo> select(int num) {
        return Posts.stream()
                .filter(p -> p.getId() == num)
                .findAny();
    }
    public List<PostVo> selectAll(){
        return Posts;
    }
}
