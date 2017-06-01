package com.cuandorindov2.main.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
@Entity
public class Signature implements Serializable {

    private static final long serialVersionUID = -8243904101939659961L;
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private Boolean coursingActive;

    public static Signature createFromName(final String name) {
        final Signature s = new Signature();
        s.setName(name);
        return s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Boolean getCoursingActive() {
        return coursingActive;
    }

    public void setCoursingActive(Boolean coursingActive) {
        this.coursingActive = coursingActive;
    }
}
