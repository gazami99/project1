package com.example.project.vo;


import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class PostVo {

    private Long id;
    private String userName;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private String title;
    private String body;

}
