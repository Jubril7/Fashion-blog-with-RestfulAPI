package com.example.week_8_task_jubril.Controller;

import com.example.week_8_task_jubril.DTO.PersonDTO;
import com.example.week_8_task_jubril.Model.Person;
import com.example.week_8_task_jubril.Services.LikeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("blog/design/")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @PostMapping("like/{designId}")
    public ResponseEntity<String> updateLike(@PathVariable(value = "designId") Long designId, HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        boolean message = likeService.like(person, designId);
        if (message){
            return new ResponseEntity<>("Successfully liked design", HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>("Successfully unliked design", HttpStatus.CREATED);
        }
    }

    @DeleteMapping("unlike/{likeId}")
    public ResponseEntity<String> removeLike(@PathVariable(value = "likeId")Long likeId) {
        likeService.unlike(likeId);
        return new ResponseEntity<>("Unlike Success", HttpStatus.OK);
    }
}
