package com.cuandorindov2.main.resources.crud.domain;

import com.cuandorindov2.main.model.Student;
import com.cuandorindov2.main.repositories.StudentRepository;
import com.cuandorindov2.main.resources.responses.Students;
import com.cuandorindov2.main.resources.responses.mappers.StudentMapper;
import com.cuandorindov2.utils.rest.AppTypes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.cuandorindov2.utils.rest.URLConstants.GET_ALL;
import static com.cuandorindov2.utils.rest.URLConstants.PREFIX_STUDENT;
import static com.cuandorindov2.utils.rest.URLConstants.SAVE;
import static com.cuandorindov2.utils.rest.URLConstants.SLASH;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
@RestController
@RequestMapping(path = SLASH + PREFIX_STUDENT, consumes = AppTypes.APPLICATION_JSON,
        produces = AppTypes.APPLICATION_JSON)
@Api(value = "Students controller", description = "Operations for Students")
public class StudentController {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @RequestMapping(path = SAVE, method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save one student, the establishments can be null.", response = Student.class, httpMethod = "POST")
    public Student saveStudent(@RequestBody @ApiParam(required = true) final Student student) {
        return studentRepository.save(student);
    }

    @RequestMapping(path = GET_ALL, method = GET)
    @ResponseStatus(OK)
    @ApiOperation(value = "Retrieve all the students in the webapp.", response = Students.class)
    public Students getAllStudents() {
        return studentMapper.map();
    }
}
