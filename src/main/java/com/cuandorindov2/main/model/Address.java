package com.cuandorindov2.main.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import static javax.persistence.CascadeType.ALL;

/**
 * Created by tomas.lingotti on 31/05/17.
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = -6730170743623956663L;

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String number;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
