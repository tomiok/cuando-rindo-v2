package com.cuandorindov2.main.resources.responses;

import com.cuandorindov2.main.model.Student;
import java.util.Collection;
import java.util.Collections;

/**
 * Response Object, for mapping all the students in the BBDD.
 * Created by tomas.lingotti on 30/05/17.
 */
public class Students {

    private Collection<Student> students;

    public Collection<Student> getStudents() {
        return Collections.unmodifiableCollection(this.students);
    }

    private Students (final Collection<Student> students) {
        this.students = students;
    }

    public static Students build(final Collection<Student> students) {
        return new Students(students);
    }
}
