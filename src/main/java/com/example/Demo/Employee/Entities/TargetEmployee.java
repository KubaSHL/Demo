package com.example.Demo.Employee.Entities;

import jakarta.xml.bind.annotation.*;

@XmlRegistry
@XmlRootElement(name = "Target")
@XmlType(propOrder = {"ID","FirstName","LastName","Mobile","Email","Pesel"})
@XmlAccessorType(XmlAccessType.FIELD)

public class TargetEmployee {


    private String employeeId;

    private String firstName;

    private String lastName;

    private String mobile;

    private String email;

    private String pesel;

    public String getId() {
        return employeeId;
    }
    @XmlElement(name = "ID")
    public void setId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    @XmlElement(name = "Mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }


    @XmlElement(name = "Pesel")
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


    public TargetEmployee() {
    }
    private String typeOfContract = "internal";

    public String getTypeOfContract() {
        return typeOfContract;
    }
    @XmlTransient
    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public String getFilePath(){
        return String.format("D:/%s/%s_%s_%s.xml",getTypeOfContract(),getId(),getFirstName(),getLastName(),getMobile());
    }
}
