package com.example.week_8_task_jubril.Model;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;
//    private Long personId;
//    private Long designId;

    @ManyToOne
    @JoinColumn(name = "design_id")
    private Design design;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
