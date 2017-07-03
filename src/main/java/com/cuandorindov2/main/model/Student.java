package com.cuandorindov2.main.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


import static javax.persistence.CascadeType.PERSIST;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 5618910582951229913L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "mid_name")
    private String midName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(cascade = PERSIST)
    @JoinTable(name = "students_establishments",
    joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "establishment_id", referencedColumnName = "id"))
    private Collection<Establishment> establishments;
    @OneToOne(cascade = PERSIST)
    private Address address;
    @OneToOne
    private Email email;
    @Column
    private String countryCode;

    private String phoneNumber;

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

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(Collection<Establishment> establishments) {
        this.establishments = establishments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
