package com.cuandorindov2.main.resources.crud.domain;


import com.cuandorindov2.main.model.Course;
import com.cuandorindov2.main.model.Establishment;
import com.cuandorindov2.main.model.Signature;
import com.cuandorindov2.main.model.Student;
import com.cuandorindov2.main.repositories.EstablishmentRepository;
import com.cuandorindov2.main.repositories.SignatureRepository;
import com.cuandorindov2.main.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.cuandorindov2.utils.rest.AppTypes.APPLICATION_JSON;
import static com.cuandorindov2.utils.rest.URLConstants.PREFIX_SIGNATURE;
import static com.cuandorindov2.utils.rest.URLConstants.SAVE;
import static com.cuandorindov2.utils.rest.URLConstants.SLASH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
@RestController
@RequestMapping(path = SLASH + PREFIX_SIGNATURE,
consumes = APPLICATION_JSON,
produces = APPLICATION_JSON)
public class SignatureController {

    private final SignatureRepository signatureRepository;
    private final StudentRepository studentRepository;
    private final EstablishmentRepository establishmentRepository;

    @Autowired
    public SignatureController(SignatureRepository signatureRepository, StudentRepository studentRepository, EstablishmentRepository establishmentRepository) {
        this.signatureRepository = signatureRepository;
        this.studentRepository = studentRepository;
        this.establishmentRepository = establishmentRepository;
    }

    @RequestMapping(path = SAVE, method = POST)
    @Transactional
    public Signature saveSignature(@RequestBody final Course course) {

        Student student = studentRepository.getOne(course.getStudentId());

        Optional<Establishment> establishmentOptional = student.getEstablishments()
                .stream()
                .filter(e -> e.getId().equals(course.getEstablishmentId()))
                .findFirst();

        if (establishmentOptional.isPresent()) {
            Establishment establishment = establishmentOptional.get();
            establishment.setSignatures(course.getSignatures());
            studentRepository.save(student);
        }
        return null;
    }
}
