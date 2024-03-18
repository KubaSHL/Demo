package com.example.Demo.Employee.Entities;

import jakarta.xml.bind.annotation.*;


@XmlTransient
//@XmlType(propOrder = {"ID","FirstName","LastName","Mobile","Email","Pesel"})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Person {
    @XmlElement(name = "ID")
    private String employeeId;

    @XmlElement(name = "FirstName")
    private String firstName;

    @XmlElement(name = "LastName")
    private String lastName;

    @XmlElement(name = "Mobile")
    private String mobile;

    @XmlElement(name = "Email")
    private String email;

    @XmlElement(name = "Pesel")
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
