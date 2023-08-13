package com.example.week_8_task_jubril.Converter;

import com.example.week_8_task_jubril.DTO.CommentDTO;
import com.example.week_8_task_jubril.Model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    public Comment DTOtoModel(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setCommentId(commentDTO.getCommentId());
        comment.setText(commentDTO.getText());
        return comment;
    }

    public CommentDTO ModelToDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(comment.getCommentId());
        commentDTO.setText(comment.getText());
        return commentDTO;
    }
}
