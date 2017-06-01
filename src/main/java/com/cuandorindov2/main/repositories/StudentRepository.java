package com.cuandorindov2.main.repositories;

import com.cuandorindov2.main.model.Student;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "FROM Student")
    Collection<Student> getAllStudents();
}
