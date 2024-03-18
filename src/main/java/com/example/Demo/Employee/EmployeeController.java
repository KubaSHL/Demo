package com.example.Demo.Employee;

import com.example.Demo.Employee.Entities.ExternalEmployee;
import com.example.Demo.Employee.Entities.InternalEmployee;
import com.example.Demo.Employee.Entities.Person;
import com.sun.istack.NotNull;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.PropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/v1/productCard")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "EmployeeController is responding.";
    }

    @GetMapping("/getEmployee/{type}")
    public Person getEmployee(@PathVariable String type, @NotNull @RequestBody String firstName, @NotNull @RequestBody String lastName, @NotNull @RequestBody String mobile) throws JAXBException, IOException {
        if(type.equalsIgnoreCase("internal")){
            InternalEmployee internalEmployee = new InternalEmployee();
            internalEmployee.setFirstName(firstName);
            internalEmployee.setLastName(lastName);
            internalEmployee.setMobile(mobile);
            return employeeService.getInternalEmployee(internalEmployee);
        }
        else if (type.equalsIgnoreCase("external")){
            ExternalEmployee externalEmployee = new ExternalEmployee();
            externalEmployee.setFirstName(firstName);
            externalEmployee.setLastName(lastName);
            externalEmployee.setMobile(mobile);
            return employeeService.getExternalEmployee(externalEmployee);
        }
        else {
            throw new PropertyException("Wrong employee type.");
        }
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public boolean deleteEmployee(@PathVariable String employeeId) throws IOException {
        return employeeService.deleteEmployeeOfId(employeeId);
    }

    @PostMapping("/addEmployee/{type}")
    public void addEmployee(@PathVariable String type, @RequestBody Person employee) throws IOException, JAXBException {
        if(type.equalsIgnoreCase("internal")){
        employeeService.createInternalEmployee( (InternalEmployee) employee);
        }
        else if(type.equalsIgnoreCase("external")){
            employeeService.createExternalEmployee( (ExternalEmployee) employee);
        }
        else {
            throw new PropertyException("Wrong employee type.");
        }
    }

    @PutMapping("/updateEmployee/{type}")
    public void updateEmployee(@PathVariable String type, @RequestBody Person employee) throws JAXBException, IOException {
        if(type.equalsIgnoreCase("internal")){
            employeeService.modifyInternalEmployee( (InternalEmployee) employee);
        }
        else if(type.equalsIgnoreCase("external")){
            employeeService.modifyExternalEmployee( (ExternalEmployee) employee);
        }
        else {
            throw new PropertyException("Wrong employee type.");
        }
    }


}
