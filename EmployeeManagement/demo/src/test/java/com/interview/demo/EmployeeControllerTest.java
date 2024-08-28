package com.interview.demo;

import com.interview.demo.Controller.EmployeeController;
import com.interview.demo.Entity.Employee;
import com.interview.demo.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    @Order(2)
    void testCreateEmployee() {
        // Arrange
        Employee employee = new Employee();
        employee.setFirstName("tharu");
        employee.setLastName("Doe");
        employee.setEmail("tharuisha@example.com");
        employee.setSalary(50000.00);

        System.out.println(employee);

        when(employeeService.createEmployee(any(Employee.class))).thenReturn(employee);

        // Act
        Employee createdEmployee = employeeController.createEmployees(employee);

        // Assert
        assertEquals("tharu", createdEmployee.getFirstName());
        assertEquals("Doe", createdEmployee.getLastName());
        assertEquals("tharuisha@example.com", createdEmployee.getEmail());
        assertEquals(50000.0, createdEmployee.getSalary());
    }

    @Test
    @Order(1)
    void testGetEmployeeById() {
        // Arrange
        Long employeeId = 1L;
        Employee employee = new Employee(employeeId, "John", "Doe", "john.doe@example.com", 50000.0);

        when(employeeService.getEmployeeById(employeeId)).thenReturn(employee);

        // Act
        ResponseEntity<Employee> responseEntity = employeeController.getUser(employeeId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("John", responseEntity.getBody().getFirstName());
        assertEquals("Doe", responseEntity.getBody().getLastName());
        assertEquals("john.doe@example.com", responseEntity.getBody().getEmail());
        assertEquals(50000.0, responseEntity.getBody().getSalary());
    }

}
