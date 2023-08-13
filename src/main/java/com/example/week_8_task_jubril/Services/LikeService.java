package com.example.week_8_task_jubril.Services;

public interface LikeService {
    String like(Long personId, Long designId);
    void unlike(Long likeId);
}
