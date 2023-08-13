package com.example.week_8_task_jubril.Services.ServiceImpl;

import com.example.week_8_task_jubril.Converter.DesignConverter;
import com.example.week_8_task_jubril.DTO.CategoryDTO;
import com.example.week_8_task_jubril.DTO.DesignDTO;
import com.example.week_8_task_jubril.Model.Category;
import com.example.week_8_task_jubril.Model.Comment;
import com.example.week_8_task_jubril.Model.Design;
import com.example.week_8_task_jubril.Model.Person;
import com.example.week_8_task_jubril.Repository.CategoryRepo;
import com.example.week_8_task_jubril.Repository.DesignRepo;
import com.example.week_8_task_jubril.Services.DesignService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DesignServiceImpl implements DesignService {
    private final DesignRepo designRepo;
    private final CategoryRepo categoryRepo;
    private final DesignConverter designConverter;
//    private CommentRepo commentRepo;
//    private LikeRepo likeRepo;
    @Autowired
    public DesignServiceImpl(DesignRepo designRepo, CategoryRepo categoryRepo, DesignConverter designConverter ) {
        // , CommentRepo commentRepo, LikeRepo likeRepo//
        this.designRepo = designRepo;
        this.categoryRepo = categoryRepo;
        this.designConverter = designConverter;
//        this.commentRepo = commentRepo;
//        this.likeRepo = likeRepo;
    }
    @Override
    public ResponseEntity<DesignDTO> createNewDesign(DesignDTO designDTO, HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        Category category = categoryRepo.findById(designDTO.getCategoryId()).orElseThrow(NullPointerException::new);
        if (category != null) {
            Design design = designConverter.DTOtoModel(designDTO);
            System.out.println(design);
            //design.setCategoryId(categoryId);
            Design newDesign = designRepo.save(design);
            return new ResponseEntity<>(designConverter.ModelToDTO(newDesign), HttpStatus.OK);
        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<List<DesignDTO>> getAllDesigns(HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        List<Design> designList = designRepo.findAll();
        return new ResponseEntity<>(designList.stream().map(designConverter::ModelToDTO).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DesignDTO> getDesignById(Long designId, HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        Design design = designRepo.findById(designId).orElseThrow(NullPointerException::new);
        DesignDTO designDTO = designConverter.ModelToDTO(design);
        return new ResponseEntity<>(designDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DesignDTO> updateDesign(Long designId, DesignDTO designDTO, HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        Design design = designRepo.findById(designId).orElseThrow(NullPointerException::new);
        design.setDesignName(designDTO.getDesignName());
        design.setDesignDescription(designDTO.getDesignDescription());
        design.setDesignPrice(designDTO.getDesignPrice());
        Design updatedDesign = designRepo.save(design);
        return new ResponseEntity<>(designConverter.ModelToDTO(updatedDesign), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> deleteDesign(Long designId, HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        Design design = designRepo.findById(designId).orElseThrow(NullPointerException::new);
        deleteDesignComment(designId);
        designRepo.delete(design);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }

    @Override
    public void deleteDesignComment(Long designId) {

    }


    public Design getDesignById(Long designId) {
        return designRepo.findById(designId).get();
    }

}
