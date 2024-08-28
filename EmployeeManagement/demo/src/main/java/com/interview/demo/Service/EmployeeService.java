package com.interview.demo.Service;

import com.interview.demo.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Long id, Employee employee);
    public void deleteEmployee(Long id);
}
