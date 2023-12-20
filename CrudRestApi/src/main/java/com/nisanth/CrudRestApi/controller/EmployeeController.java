package com.nisanth.CrudRestApi.controller;

import com.nisanth.CrudRestApi.exception.ResourceNotFoundException;
import com.nisanth.CrudRestApi.model.Employee;
import com.nisanth.CrudRestApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // capable to handle all http methods
@RequestMapping("/api/v1/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all values
    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    // build create employee Rest Api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        //RequestBody- Convert JSOSN object to java object
        return employeeRepository.save(employee);
    }

    // build get employee by if REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with this id"+id));
        return ResponseEntity.ok(employee);
    }

    // build update emloyee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails)
    {
        Employee updateEmployee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id"+id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    // build delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
    {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee not found this id"+id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
