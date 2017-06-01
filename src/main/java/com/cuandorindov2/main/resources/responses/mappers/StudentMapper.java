package com.cuandorindov2.main.resources.responses.mappers;

import com.cuandorindov2.main.repositories.StudentRepository;
import com.cuandorindov2.main.resources.responses.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tomas.lingotti on 30/05/17.
 */
@Component
public class StudentMapper {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentMapper(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Students map() {
        return Students.build(studentRepository.getAllStudents());
    }
}
