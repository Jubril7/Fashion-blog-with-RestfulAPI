package com.example.week_8_task_jubril.Services.ServiceImpl;
import com.example.week_8_task_jubril.Converter.PersonConverter;
import com.example.week_8_task_jubril.DTO.PersonDTO;
import com.example.week_8_task_jubril.Model.Person;
import com.example.week_8_task_jubril.Repository.PersonRepo;
import com.example.week_8_task_jubril.Services.PersonService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;
    private final PersonConverter personConverter;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo, PersonConverter personConverter){
        this.personRepo = personRepo;
        this.personConverter = personConverter;
    }

    @Override
    public ResponseEntity<PersonDTO> savePerson(PersonDTO personDTO) {
        Person user = personConverter.DTOtoModel(personDTO);
        Person savedUser = personRepo.save(user);
        PersonDTO res = personConverter.ModelToDTO(savedUser);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> allPerson(HttpSession session) {
        List<Person> persons = personRepo.findAll();
        List<PersonDTO> personsDTO = new ArrayList<>();
        for(Person person1 : persons) {
            PersonDTO personDTO = personConverter.ModelToDTO(person1);
            personsDTO.add(personDTO);
        }
        return new ResponseEntity<>(personsDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> findPersonById(Long personId) {
        Person person = personRepo.findById(personId).orElseThrow(NullPointerException::new);
        return new ResponseEntity<>(personConverter.ModelToDTO(person), HttpStatus.OK);
    }

    public ResponseEntity<String> login(PersonDTO personDTO, HttpSession session) {
        Optional<Person> person = Optional.ofNullable(personRepo.findByUsernameAndPassword(personDTO.getUsername(), personDTO.getPassword()));
        if(person.isPresent()) {
            Person loggedIn = person.get();
            if(loggedIn.getPassword().equals(personDTO.getPassword())){
                session.setAttribute("person", loggedIn);
                return new ResponseEntity<>("Login Success", HttpStatus.OK);
            }
        }
        return null;
    }

    //Todo: implement logout
}
