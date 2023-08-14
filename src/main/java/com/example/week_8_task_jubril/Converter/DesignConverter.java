package com.example.week_8_task_jubril.Converter;

import com.example.week_8_task_jubril.DTO.DesignDTO;
import com.example.week_8_task_jubril.Model.Design;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DesignConverter {
    //Todo: learn to use model mapper
//    @Autowired
//    private ModelMapper mapper;

//    public DesignConverter(ModelMapper modelMapper){
//        this.modelMapper = modelMapper;
//    }

    public Design DTOtoModel(DesignDTO designDTO) {
        Design design = new Design();
        design.setDesignName(designDTO.getDesignName());
        design.setDesignDescription(designDTO.getDesignDescription());
        design.setCategoryId(designDTO.getCategoryId());
        design.setDesignPrice(designDTO.getDesignPrice());
        return design;
    }

    public DesignDTO ModelToDTO(Design design) {
        DesignDTO designDTO = new DesignDTO();
        designDTO.setDesignName(design.getDesignName());
        designDTO.setDesignDescription(design.getDesignDescription());
        designDTO.setDesignPrice(design.getDesignPrice());
        designDTO.setCategoryId(design.getCategoryId());
        designDTO.setCommentSet(design.getCommentSet());
        System.out.println("<<<<<>>>>");
        designDTO.setLikes(design.getLikes().size());
        return designDTO;
    }
}
