package com.example.Demo.Employee.Entities;

import jakarta.xml.bind.annotation.*;

@XmlType(name = "internal")
@XmlRootElement
public class InternalEmployee extends Person {

    private String typeOfContract = "internal";

    public InternalEmployee(Person employee) {
        if(!employee.getId().isEmpty()) this.setId(employee.getId());
        if(!employee.getFirstName().isEmpty()) this.setFirstName(employee.getFirstName());
        if(!employee.getLastName().isEmpty()) this.setLastName(employee.getLastName());
        if(!employee.getEmail().isEmpty()) this.setEmail(employee.getEmail());
        if(!employee.getMobile().isEmpty()) this.setMobile(employee.getMobile());
        if(!employee.getPesel().isEmpty()) this.setPesel(employee.getPesel());
    }

    public InternalEmployee() {
    }

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
