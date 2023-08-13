package com.example.week_8_task_jubril.Model;

import com.example.week_8_task_jubril.DTO.CategoryDTO;
import com.example.week_8_task_jubril.DTO.DesignDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Design {

    // Todo: category id and design id not showing in the fields
    //Fixme: fix simple like
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long designId;
    @Column(nullable = false)
    private String designName;
    @Column(nullable = false)
    private String designDescription;
    private Double designPrice;
    @Column
    private Long categoryId;
    @OneToMany
    private List<Comment> commentSet = new ArrayList<>();

}
