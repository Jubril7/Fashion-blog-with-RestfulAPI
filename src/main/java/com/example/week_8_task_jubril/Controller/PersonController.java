package com.example.week_8_task_jubril.Controller;

import com.example.week_8_task_jubril.DTO.PersonDTO;
import com.example.week_8_task_jubril.Services.PersonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/person/")
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("create-person")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        return personService.savePerson(personDTO);
    }

    @GetMapping("get-all-persons")
    public ResponseEntity<List<PersonDTO>> getPersons(HttpSession session) {
        return personService.allPerson(session);
    }

    @GetMapping("get-person/{personId}")
    public ResponseEntity<PersonDTO> getOnePerson(@PathVariable(value = "personId") Long personId, HttpSession session) {
        PersonDTO personDTO = (PersonDTO) session.getAttribute("person");
        if(personDTO != null) {
            return personService.findPersonById(personId);
        }
        return personService.findPersonById(personId);
    }
    @PostMapping("login")
    public ResponseEntity<String> loginAPerson(@RequestBody PersonDTO personDTO, HttpSession session) {
        return personService.login(personDTO, session);
    }

}
