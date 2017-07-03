package com.cuandorindov2.main.mapper.toDomain;

import com.cuandorindov2.main.mapper.AbstractMapper;
import com.cuandorindov2.main.model.Address;
import com.cuandorindov2.main.model.Email;
import com.cuandorindov2.main.model.Establishment;
import com.cuandorindov2.main.model.Student;
import com.cuandorindov2.main.resources.requests.StudentRequest;
import java.util.Collection;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public class StudentMapper implements AbstractMapper<StudentRequest, Student> {

    @Override
    public Student map(StudentRequest entity) {
        Student student =
                new StudentBuilder()
                    .name(entity.getName())
                    .midName(entity.getMidName())
                    .lastName(entity.getLastName())
                    .address(entity.getAddress())
                    .email(entity.getEmail())
                    .establishments(entity.getEstablishments())
                    .build();

        return student;
    }

    private static class StudentBuilder {
        private String name;
        private String midName;
        private String lastName;
        private Collection<Establishment> establishments;
        private Address address;
        private Email email;

        StudentBuilder name(final String name) {
            this.name = name;
            return this;
        }

        StudentBuilder midName(final String midName) {
            this.midName = midName;
            return this;
        }

        StudentBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        StudentBuilder establishments(final Collection<Establishment> ests) {
            this.establishments = ests;
            return this;
        }

        StudentBuilder address(final Address address) {
            this.address = address;
            return this;
        }

        StudentBuilder email(final Email email) {
            this.email = email;
            return this;
        }

        Student build() {
            Student st = new Student();
            st.setName(this.name);
            st.setMidName(this.midName);
            st.setLastName(this.lastName);
            st.setAddress(this.address);
            st.setEmail(this.email);
            st.setEstablishments(this.establishments);
            return st;
        }
    }
}
