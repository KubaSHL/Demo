package com.example.Demo.Employee.Entities;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public Person createInternalEmployee() {
        return new InternalEmployee();
    }


    public Person createExternalEmployee() {
        return new ExternalEmployee();
    }
}
