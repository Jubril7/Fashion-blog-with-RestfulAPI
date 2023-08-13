package com.example.week_8_task_jubril.Model;

import com.example.week_8_task_jubril.DTO.PersonDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;





}
