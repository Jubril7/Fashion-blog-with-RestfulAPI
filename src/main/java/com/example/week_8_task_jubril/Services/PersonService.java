package com.example.week_8_task_jubril.Services;

import com.example.week_8_task_jubril.DTO.PersonDTO;
import com.example.week_8_task_jubril.Model.Person;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PersonService {
    ResponseEntity<PersonDTO> savePerson(PersonDTO personDTO);
    ResponseEntity<List<PersonDTO>> allPerson(HttpSession session);
    ResponseEntity<PersonDTO> findPersonById(Long id);
    ResponseEntity<String> login(PersonDTO personDTO, HttpSession session);

}
