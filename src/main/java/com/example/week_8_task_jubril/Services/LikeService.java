package com.example.week_8_task_jubril.Services;

import com.example.week_8_task_jubril.Model.Person;

public interface LikeService {
    boolean like(Person person, Long designId);
    void unlike(Long likeId);
}
