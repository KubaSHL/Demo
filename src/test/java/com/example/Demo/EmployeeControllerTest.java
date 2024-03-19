package com.example.Demo;

import com.example.Demo.Employee.EmployeeController;
import com.example.Demo.Employee.EmployeeService;
import com.example.Demo.Employee.Entities.ExternalEmployee;
import com.example.Demo.Employee.Entities.InternalEmployee;
import com.example.Demo.Employee.Entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void gettingEmployee(){

        List<String> exceptions = new ArrayList<>();
        InternalEmployee ie = new InternalEmployee();
        ie.setId("ieTestId1");
        ie.setFirstName("Ann");
        ie.setLastName("Cook");
        ie.setEmail("ann.cook@gmail.com");
        ie.setMobile("098230123");
        ie.setPesel("9309281920391");
        InternalEmployee comp = new InternalEmployee();
        try {
            comp = (InternalEmployee) employeeController.getEmployee("internal", ie.getMobile() ,ie.getLastName(), ie.getFirstName());
        }catch (Exception exception){
            exceptions.add(exception.getMessage());
        }

        assertTrue(exceptions.isEmpty() && Objects.equals(comp.getLastName(), ie.getLastName()) && Objects.equals(comp.getFirstName(), ie.getFirstName()) && Objects.equals(comp.getId(), ie.getId()));
    }

    @Test
    void savingNewEmployee() {
        List<String> exceptions = new ArrayList<>();
        InternalEmployee ie = new InternalEmployee();
        ie.setId("ieTestId1");
        ie.setFirstName("Ann");
        ie.setLastName("Cook");
        ie.setEmail("ann.cook@gmail.com");
        ie.setMobile("098230123");
        ie.setPesel("9309281920391");
        ExternalEmployee ee = new ExternalEmployee();
        ee.setId("eeTestId1");
        ee.setFirstName("Rowan");
        ee.setLastName("Stray");
        ee.setEmail("ponyuni@rowan.com");
        ee.setMobile("098093751");
        ee.setPesel("9709281540391");

        try {
            employeeController.addEmployee("internal", ie);
        }catch (Exception exception){
            exceptions.add(exception.getMessage());
        }
        try {
            employeeController.addEmployee("external", ee);
        }catch (Exception exception){
            exceptions.add(exception.getMessage());
        }
        assertTrue(exceptions.isEmpty());
    }

    @Test
    void updatingEmployee(){

        List<String> exceptions = new ArrayList<>();
        InternalEmployee ie = new InternalEmployee();
        ie.setId("ieTestId1");
        ie.setFirstName("Ann");
        ie.setLastName("Cook");
        ie.setEmail("ann.cook@gmail.com");
        ie.setMobile("098230123");
        ie.setPesel("9309281920391");

        try {
            employeeController.addEmployee("internal", ie);
        }catch (Exception exception){}

        ie.setFirstName("Hanna");
        ie.setLastName("Rock");

        try {
            employeeController.updateEmployee("internal", ie);
        }catch (Exception exception){
            exceptions.add(exception.getMessage());
        }
        InternalEmployee comp = new InternalEmployee();
        try {
            comp = (InternalEmployee)  employeeController.getEmployee("internal", ie.getMobile() ,ie.getLastName(), ie.getFirstName());
        }catch (Exception exception){}

        assertTrue(exceptions.isEmpty() && comp.getFirstName().equalsIgnoreCase("Hanna") && comp.getLastName().equalsIgnoreCase("Rock") );

    }

    @Test
    void deletingEmployee(){

        List<String> exceptions = new ArrayList<>();
        InternalEmployee ie = new InternalEmployee();
        ie.setId("ieTestId1");
        ie.setFirstName("Ann");
        ie.setLastName("Cook");
        ie.setEmail("ann.cook@gmail.com");
        ie.setMobile("098230123");
        ie.setPesel("9309281920391");

        try {
            employeeController.addEmployee("internal", ie);
        }catch (Exception exception){}

        try {
            employeeController.deleteEmployee(ie.getId());
        }catch (Exception exception){
            exceptions.add(exception.getMessage());
        }

        assertTrue(exceptions.isEmpty() && !new File(ie.getFilePath()).exists());
    }



}
