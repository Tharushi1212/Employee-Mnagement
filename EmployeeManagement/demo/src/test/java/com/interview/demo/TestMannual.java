package com.interview.demo;

import com.interview.demo.Entity.Employee;
import com.interview.demo.Service.EmployeeService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TestMannual {

    @Autowired
    EmployeeService employeeService;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @Test
    void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("tharu");
        employee.setLastName("Doe");
        employee.setEmail("tharuisha1@example.com");
        employee.setSalary(50000.00);

        Employee empReturn = employeeService.createEmployee(employee);
        assertEquals("tharu", empReturn.getFirstName());
        assertEquals("Doe", empReturn.getLastName());
        assertEquals("tharuisha1@example.com", empReturn.getEmail());
        assertEquals(50000.0, empReturn.getSalary());

    }


    @AfterAll
    static void afterAllTests() {
        System.out.println("After all tests");
    }
}
