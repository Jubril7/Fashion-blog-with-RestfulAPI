package com.example.week_8_task_jubril.Services.ServiceImpl;

import com.example.week_8_task_jubril.Converter.CommentConverter;
import com.example.week_8_task_jubril.DTO.CommentDTO;
import com.example.week_8_task_jubril.DTO.DesignDTO;
import com.example.week_8_task_jubril.Model.Comment;
import com.example.week_8_task_jubril.Model.Design;
import com.example.week_8_task_jubril.Model.Person;
import com.example.week_8_task_jubril.Repository.CommentRepo;
import com.example.week_8_task_jubril.Repository.DesignRepo;
import com.example.week_8_task_jubril.Repository.PersonRepo;
import com.example.week_8_task_jubril.Services.CommentService;
import com.example.week_8_task_jubril.Services.PersonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final DesignRepo designRepo;
    private final PersonRepo personRepo;
    private final CommentConverter converter;
    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo, DesignRepo designRepo, PersonRepo personRepo, CommentConverter converter) {
        this.commentRepo = commentRepo;
        this.designRepo = designRepo;
        this.personRepo = personRepo;
        this.converter = converter;
    }

    @Override
    public ResponseEntity<String> createComment(Long designId, CommentDTO commentDTO, HttpSession session) {
        Person loggedPerson = (Person) session.getAttribute("person");
        if(loggedPerson != null) {
            Comment comment = converter.DTOtoModel(commentDTO);
            Design design = designRepo.findById(designId).orElseThrow(NullPointerException::new);
            Person person = personRepo.findById(loggedPerson.getPersonId()).orElseThrow(NullPointerException::new);
            comment.setDesignId(design.getDesignId());
            comment.setPersonId(person.getPersonId());
            design.getCommentSet().add(comment);
            commentRepo.save(comment);
            return new ResponseEntity<>("Create Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Create Fail", HttpStatus.FORBIDDEN);
    }

    @Override
    public ResponseEntity<List<CommentDTO>> getCommentsByDesignId(Long designId, HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        if(person != null) {
            List<Comment> comment = commentRepo.findByDesignId(designId);
            return new ResponseEntity<>(comment.stream().map(converter::ModelToDTO)
                    .toList(), HttpStatus.OK);
        }
        return null;
    }
}
