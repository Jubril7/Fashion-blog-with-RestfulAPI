package com.example.week_8_task_jubril.Services.ServiceImpl;

import com.example.week_8_task_jubril.Model.Likes;
import com.example.week_8_task_jubril.Repository.LikeRepo;
import com.example.week_8_task_jubril.Services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepo likeRepo;

    @Autowired
    public LikeServiceImpl(LikeRepo likeRepo) {
        this.likeRepo = likeRepo;
    }
    @Override
    public String like(Long personId, Long designId) {
        Likes like = null;
        try{
            like = likeRepo.findLikesByPersonIdAndDesignId(personId, designId);
        } catch(Exception e) {}
        if(like != null) return "Already like";

        like = new Likes();
        like.setPersonId(personId);
        like.setDesignId(designId);
        likeRepo.save(like);
        return "Like Success";
    }

    @Override
    public void unlike(Long likeId) {
        Likes like = likeRepo.findById(likeId).orElseThrow(NullPointerException::new);
        likeRepo.delete(like);
    }
}
