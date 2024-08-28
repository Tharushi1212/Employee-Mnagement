package com.interview.demo.Controller;

import com.interview.demo.Entity.Employee;
import com.interview.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //Retrieve all employees
    @GetMapping("/employee/getall")
    public ResponseEntity<List<Employee>> getEmployee() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //create an employee
    @PostMapping("/employees/create")
    public Employee createEmployees(@RequestBody Employee employees) {
        try {
            return employeeService.createEmployee(employees);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getUser(@PathVariable Long id) {
        Employee user = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //delete employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (id != null) {
            employeeService.deleteEmployee(id);
            return "Employee deleted successfully";
        } else {
            return "employee id is null";
        }
    }

}
