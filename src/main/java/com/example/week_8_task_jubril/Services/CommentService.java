package com.example.week_8_task_jubril.Services;

import com.example.week_8_task_jubril.DTO.CommentDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CommentService {
    ResponseEntity<String> createComment(Long designId, CommentDTO commentDTO, HttpSession session);
    ResponseEntity<List<CommentDTO>> getCommentsByDesignId(Long designId, HttpSession session);
}
