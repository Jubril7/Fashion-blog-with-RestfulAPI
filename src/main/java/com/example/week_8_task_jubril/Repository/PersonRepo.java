package com.example.week_8_task_jubril.Repository;

import com.example.week_8_task_jubril.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByUsernameAndPassword(String userName, String password);
}
