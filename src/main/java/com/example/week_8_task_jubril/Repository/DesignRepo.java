package com.example.week_8_task_jubril.Repository;

import com.example.week_8_task_jubril.Model.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignRepo extends JpaRepository<Design, Long> {
}
