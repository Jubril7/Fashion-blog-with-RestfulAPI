package com.example.week_8_task_jubril.Services;

import com.example.week_8_task_jubril.DTO.DesignDTO;
import com.example.week_8_task_jubril.Model.Design;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DesignService {
    ResponseEntity<DesignDTO> createNewDesign(DesignDTO designDTO, HttpSession session);
    ResponseEntity<List<DesignDTO>> getAllDesigns(HttpSession session);
    ResponseEntity<DesignDTO> getDesignById(Long designId, HttpSession session);
    ResponseEntity<DesignDTO> updateDesign(Long designId, DesignDTO designDTO, HttpSession session);
    ResponseEntity<String> deleteDesign(Long designId, HttpSession session);
    void deleteDesignComment(Long designId);
    Design getDesignById(Long designId);

}
