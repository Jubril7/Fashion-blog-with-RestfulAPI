package com.example.week_8_task_jubril.Services.ServiceImpl;

import com.example.week_8_task_jubril.Model.Design;
import com.example.week_8_task_jubril.Model.Likes;
import com.example.week_8_task_jubril.Model.Person;
import com.example.week_8_task_jubril.Repository.DesignRepo;
import com.example.week_8_task_jubril.Repository.LikeRepo;
import com.example.week_8_task_jubril.Services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepo likeRepo;
    private final DesignRepo designRepo;

//    @Autowired
//    public LikeServiceImpl(LikeRepo likeRepo, DesignRepo de) {
//        this.likeRepo = likeRepo;
//    }
    @Override
    public boolean like(Person person, Long designId) {

        Optional<Design> design = designRepo.findById(designId);
        if (design.isEmpty()){
            throw  new NullPointerException();
        }

        Likes like = likeRepo.findLikesByDesignAndPerson(design.get(), person);
        if (like == null){
            like = new Likes();
            like.setPerson(person);
            like.setDesign(design.get());
            System.out.println("<<<<<<<<I AM UNLIKING 11 >>>>>>>>>>>>>>>>>>>>");
            likeRepo.save(like);
            System.out.println("<<<<<<<<I AM UNLIKING  22>>>>>>>>>>>>>>>>>>>>");
            return true;

        }else {
            like.setPerson(null);
            like.setDesign(null);
            System.out.println("<<<<<<<<I AM UNLIKING 33>>>>>>>>>>>>>>>>>>>>");
            likeRepo.delete(like);
            System.out.println("<<<<<<<<I AM UNLIKING 44 >>>>>>>>>>>>>>>>>>>>");
            return false;
        }

//        Likes like = null;
//        try{
//            like = likeRepo.findLikesByPersonIdAndDesignId(personId, designId);
//        } catch(Exception e) {
//
//        }
//        if(like != null) return "Already like";
//
//        like = new Likes();
//        like.setPersonId(personId);
//        like.setDesignId(designId);
//
//        likeRepo.save(like);
//        return "Like Success";
    }

    @Override
    public void unlike(Long likeId) {
        Likes like = likeRepo.findById(likeId).orElseThrow(NullPointerException::new);
        likeRepo.delete(like);
    }
}
