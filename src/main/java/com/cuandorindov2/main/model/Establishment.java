package com.cuandorindov2.main.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
@Entity
public class Establishment implements Serializable {

    private static final long serialVersionUID = -2120812464997562427L;
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Signature> signatures;

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
}
