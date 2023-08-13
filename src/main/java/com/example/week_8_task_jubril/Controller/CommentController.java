package com.example.week_8_task_jubril.Controller;

import com.example.week_8_task_jubril.DTO.CommentDTO;
import com.example.week_8_task_jubril.DTO.DesignDTO;
import com.example.week_8_task_jubril.Services.CommentService;
import com.example.week_8_task_jubril.Services.ServiceImpl.CommentServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class CommentController {
    private final CommentServiceImpl commentService;
    @Autowired
    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/{designId}")
    public ResponseEntity<String> addComment(@PathVariable(name = "designId") Long designId, @RequestBody CommentDTO commentDTO, HttpSession session) {
        return commentService.createComment(designId, commentDTO, session);

    }

    @GetMapping("/comments/{designId}")
    public ResponseEntity<List<CommentDTO>> getCommentByDesignId(@PathVariable Long designId, HttpSession session) {
        return commentService.getCommentsByDesignId(designId, session);
    }

}
