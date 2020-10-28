package com.example.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/* Java bean that represents a person*/

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    @NotNull
    private String firstname;

    @Column(name = "last_name")
    @NotNull
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
