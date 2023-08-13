package com.example.week_8_task_jubril.Controller;

import com.example.week_8_task_jubril.DTO.DesignDTO;
import com.example.week_8_task_jubril.Services.DesignService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/design/")
public class DesignController {
    private final DesignService designService;
    @Autowired
    public DesignController(DesignService designService) {
        this.designService = designService;
    }

    @PostMapping("post-new-design")
    public ResponseEntity<DesignDTO> createDesign(@RequestBody DesignDTO designDTO, HttpSession session) {
        return designService.createNewDesign(designDTO, session);
    }

    @GetMapping("get-all-design")
    public ResponseEntity<List<DesignDTO>> getAllDesigns(HttpSession session) {
        return designService.getAllDesigns(session);
    }

    @GetMapping("get-a-design/{id}")
    public ResponseEntity<DesignDTO> findDesignById(@PathVariable(name = "id") Long id, HttpSession session) {
        return designService.getDesignById(id, session);
    }

    @PutMapping("update-design/{id}")
    public ResponseEntity<DesignDTO> updateDesign(@PathVariable(name = "id")Long id, @RequestBody DesignDTO designDTO, HttpSession session){
        return designService.updateDesign(id,designDTO,session);
    }

    @DeleteMapping("delete-design/{id}")
    public ResponseEntity<String> deleteDesign(@PathVariable Long id, HttpSession session) {
        return designService.deleteDesign(id,session);
    }

}
