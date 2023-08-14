package com.example.week_8_task_jubril.Model;

import com.example.week_8_task_jubril.DTO.PersonDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


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


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Likes> likesSet = new HashSet<>();


    public void addLike(Likes like){
        if (likesSet.contains(like)){
            likesSet.remove(like);
        }else {
            likesSet.add(like);
        }

    }


}
