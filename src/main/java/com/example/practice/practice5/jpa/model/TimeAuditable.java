package com.example.practice.practice5.jpa.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public interface TimeAuditable {
    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();

    void setCreateAt(LocalDateTime createAt);
    void setUpdateAt(LocalDateTime updateAt);

}
