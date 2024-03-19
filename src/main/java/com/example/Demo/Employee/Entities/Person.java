package com.example.Demo.Employee.Entities;

import jakarta.xml.bind.annotation.*;


@XmlSeeAlso({InternalEmployee.class, ExternalEmployee.class})
public abstract class Person {
    private String employeeId;

    private String firstName;

    private String lastName;

    private String mobile;

    private String email;

    private String pesel;

    public String getId() {
        return employeeId;
    }

    public void setId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }


    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public abstract String getFilePath();
}
