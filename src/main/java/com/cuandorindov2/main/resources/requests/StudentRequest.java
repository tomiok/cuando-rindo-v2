package com.cuandorindov2.main.resources.requests;

import com.cuandorindov2.main.model.Address;
import com.cuandorindov2.main.model.Email;
import com.cuandorindov2.main.model.Establishment;
import java.util.Collection;
import javax.validation.constraints.NotNull;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public class StudentRequest {

    @NotNull
    private String name;
    private String midName;
    @NotNull
    private String lastName;
    @NotNull
    private Collection<Establishment> establishments;
    @NotNull
    private Address address;
    private Email email;

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
