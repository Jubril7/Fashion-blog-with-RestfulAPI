package com.example.week_8_task_jubril.Converter;
import com.example.week_8_task_jubril.DTO.PersonDTO;
import com.example.week_8_task_jubril.Model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {
    public Person DTOtoModel(PersonDTO personDTO) {
        Person person = new Person();
        person.setUsername(personDTO.getUsername());
        person.setPassword(personDTO.getPassword());
        return person;
    }

    public PersonDTO ModelToDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonId(person.getPersonId());
        personDTO.setUsername(person.getUsername());
        personDTO.setPassword(person.getPassword());
        return personDTO;
    }

}
