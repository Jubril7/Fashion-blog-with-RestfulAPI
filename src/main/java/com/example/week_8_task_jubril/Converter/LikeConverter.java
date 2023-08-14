package com.example.week_8_task_jubril.Converter;

import com.example.week_8_task_jubril.DTO.LikesDTO;
import com.example.week_8_task_jubril.DTO.PersonDTO;
import com.example.week_8_task_jubril.Model.Likes;
import com.example.week_8_task_jubril.Model.Person;
import org.springframework.stereotype.Component;

@Component
public class LikeConverter {
    public Likes DTOtoModel(LikesDTO likesDTO) {
        Likes like = new Likes();
        like.setLikeId(likesDTO.getLikeId());
        return like;
    }

    public LikesDTO ModelToDTO(Likes likes) {
        LikesDTO likeDTO = new LikesDTO();
        likeDTO.setLikeId(likes.getLikeId());
        return likeDTO;
    }
}
