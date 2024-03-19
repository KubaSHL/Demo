package com.example.Demo.Employee;

import com.example.Demo.Employee.Entities.ExternalEmployee;
import com.example.Demo.Employee.Entities.InternalEmployee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class EmployeeConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerProductCard(EmployeeRepository employeeRepository){
        return  args -> {
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
            employeeRepository.save(ie);
            employeeRepository.save(ee);
        };
    }

}
