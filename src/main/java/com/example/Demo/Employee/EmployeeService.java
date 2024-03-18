package com.example.Demo.Employee;

import com.example.Demo.Employee.Entities.ExternalEmployee;
import com.example.Demo.Employee.Entities.InternalEmployee;
import com.sun.istack.NotNull;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public InternalEmployee getInternalEmployee(@NotNull InternalEmployee internalEmployee) throws JAXBException, IOException {
        return (InternalEmployee) employeeRepository.find(internalEmployee);
    }

    public ExternalEmployee getExternalEmployee(@NotNull ExternalEmployee externalEmployee) throws JAXBException, IOException {
        return (ExternalEmployee) employeeRepository.find(externalEmployee);
    }

    public void createInternalEmployee(@NotNull InternalEmployee internalEmployee) throws JAXBException, IOException {
        employeeRepository.save(internalEmployee);
    }

    public void createExternalEmployee(@NotNull ExternalEmployee externalEmployee) throws JAXBException, IOException {
        employeeRepository.save(externalEmployee);
    }

    public void deleteInternalEmployee(@NotNull InternalEmployee internalEmployee) throws  IOException{
        employeeRepository.delete(internalEmployee);
    }

    public void deleteExternalEmployee(@NotNull ExternalEmployee externalEmployee) throws  IOException{
        employeeRepository.delete(externalEmployee);
    }

    public boolean deleteEmployeeOfId(@NotNull String id) throws IOException{
        return employeeRepository.deleteForce(id);
    }

    public void modifyInternalEmployee(@NotNull InternalEmployee internalEmployee) throws  JAXBException, IOException{
        employeeRepository.update(internalEmployee);
    }

    public void modifyExternalEmployee(@NotNull ExternalEmployee externalEmployee) throws  JAXBException, IOException{
        employeeRepository.update(externalEmployee);
    }
}
