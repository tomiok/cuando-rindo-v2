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

        private void setName(final String name) {
            this.name = name;
        }

        private void setMidName(final String midName) {
            this.midName = midName;
        }

        private void setLastName(final String lastName) {
            this.lastName = lastName;
        }

        private void setEstablishments(final Collection<Establishment> establishments) {
            this.establishments = establishments;
        }

        private void setAddress(final Address address) {
            this.address = address;
        }

        private void setEmail(final Email email) {
            this.email = email;
        }

        StudentBuilder name(final String name) {
            this.setName(name);
            return this;
        }

        StudentBuilder midName(final String midName) {
            this.setMidName(midName);
            return this;
        }

        StudentBuilder lastName(final String lastName) {
            this.setLastName(lastName);
            return this;
        }

        StudentBuilder establishments(final Collection<Establishment> ests) {
            this.setEstablishments(ests);
            return this;
        }

        StudentBuilder address(final Address address) {
            this.setAddress(address);
            return this;
        }

        StudentBuilder email(final Email email) {
            this.setEmail(email);
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
