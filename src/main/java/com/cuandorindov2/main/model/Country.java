package com.cuandorindov2.main.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by tomas.lingotti on 31/05/17.
 */
@Entity
public class Country implements Serializable {

    private static final long serialVersionUID = -2804817226705537028L;

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
