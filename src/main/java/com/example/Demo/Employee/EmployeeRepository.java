package com.example.Demo.Employee;

import com.example.Demo.Employee.Entities.InternalEmployee;
import com.example.Demo.Employee.Entities.ObjectFactory;
import com.example.Demo.Employee.Entities.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@Repository
public class EmployeeRepository {


    public  <T extends Person> void save(T employee) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(InternalEmployee.class, Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(employee, new File(employee.getFilePath()));
    }

    public <T extends Person> Person find(T employee) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Person.class);
        return (Person) context.createUnmarshaller().unmarshal(new FileReader(employee.getFilePath()));
    }

    public <T extends Person> void delete(T employee) throws IOException {
        File file = new File(employee.getFilePath());
        if(!file.exists()){
            throw new IOException("Failed to find file:" + employee.getFilePath());
        };
        if(!file.delete()){
            throw new IOException("Failed to delete file:" + employee.getFilePath());
        };
    }

    public boolean deleteForce(String id) throws IOException{
        File fileInter = new File("D:/internal");
        int deleted = 0;
        if( fileInter.exists() && fileInter.isDirectory() )
        {
            String[] files = fileInter.list();
            for( String fileName : Objects.requireNonNull(files))
            {
                if( fileName.contains(id) ){
                    deleted += new File(fileName).delete() ? 0 : 1;
                }

            }
        }

        File fileExt = new File("D:/external");

        if( fileExt.exists() && fileExt.isDirectory() )
        {
            String[] files = fileExt.list();
            for( String fileName : Objects.requireNonNull(files))
            {
                if( fileName.contains(id) )
                    deleted += new File(fileName).delete() ? 0 : 1;
            }
        }

        if (deleted>0){
            return false;
        }else return true;
    }

    public <T extends Person> void update(T employee) throws JAXBException, IOException {

        File file = new File(employee.getFilePath());
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        Person fileEmployeeData = (Person) context.createUnmarshaller().unmarshal(file);

        if(!employee.getFirstName().isEmpty()) fileEmployeeData.setFirstName(employee.getFirstName());
        if(!employee.getLastName().isEmpty()) fileEmployeeData.setLastName(employee.getLastName());
        if(!employee.getEmail().isEmpty()) fileEmployeeData.setEmail(employee.getEmail());
        if(!employee.getMobile().isEmpty()) fileEmployeeData.setMobile(employee.getMobile());
        if(!employee.getPesel().isEmpty()) fileEmployeeData.setPesel(employee.getPesel());

        marshaller.marshal(fileEmployeeData, file);
    }

}
