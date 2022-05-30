package org.csystem.app.service.rest.competiton.entity;

import java.time.LocalDate;

public class Director {
    private long id;
    private String firstName;
    private String middlName;
    private String familyName;
    private LocalDate birthDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddlName() {
        return middlName;
    }

    public void setMiddlName(String middlName) {
        this.middlName = middlName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
