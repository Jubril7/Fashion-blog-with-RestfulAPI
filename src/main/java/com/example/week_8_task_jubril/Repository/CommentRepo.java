package com.example.week_8_task_jubril.Repository;

import com.example.week_8_task_jubril.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByDesignId(Long commentId);
}
