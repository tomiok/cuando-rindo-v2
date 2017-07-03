package com.cuandorindov2.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
@Entity
public class Email {

    @Id
    @GeneratedValue
    private Long id;

    @org.hibernate.validator.constraints.Email(message = "Email pattern does not match. Please enter a valid address.")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }
}
