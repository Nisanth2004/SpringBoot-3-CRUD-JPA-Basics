package com.nisanth.CrudRestApi.repository;

import com.nisanth.CrudRestApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
    // all crud database methods
}
