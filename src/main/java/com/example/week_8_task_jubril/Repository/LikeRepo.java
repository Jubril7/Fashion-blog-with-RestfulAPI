package com.example.week_8_task_jubril.Repository;

import com.example.week_8_task_jubril.Model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface LikeRepo extends JpaRepository<Likes, Long> {
    Likes findLikesByPersonIdAndDesignId(Long personId, Long designId);
    List<Likes> findAllByDesignId(Long designId);
}
