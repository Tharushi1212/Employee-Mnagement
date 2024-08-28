package com.interview.demo.Service;

import com.interview.demo.Entity.Employee;
import com.interview.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //get all employees
    @Override
    public List<Employee> getAllEmployees() {
        try {

            return employeeRepository.findAll();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

    //get employee by id
    @Override
    public Employee getEmployeeById(Long id) {
        try {
            Employee user = employeeRepository.findById(id).get();
            return user;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //create a new employee
    @Override
    public Employee createEmployee(Employee employee) {
        try {
            if (employee != null) {
                Employee createdEmployee =  employeeRepository.save(employee);
                return createdEmployee;


            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"employee is not created");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return null;
    }

    //delete employee by id
    @Override
    public void deleteEmployee(Long id) {
        try {
            if(employeeRepository.existsById(id)) {
                employeeRepository.deleteById(id);
            }else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found");
            }
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

}
