package com.example.week_8_task_jubril.DTO;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDTO {
    private Long personId;
    private String username;
    private String password;
}
