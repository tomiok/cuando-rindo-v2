package com.cuandorindov2.main.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
@Entity
public class Establishment implements Serializable {

    private static final long serialVersionUID = -2120812464997562427L;
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @OneToMany(cascade = PERSIST)
    private Collection<Signature> signatures;
    @OneToOne(cascade = ALL)
    @NotNull
    private Address address;

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

    public Collection<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(Collection<Signature> signatures) {
        this.signatures = signatures;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
