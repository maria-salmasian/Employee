package com.employeeSatgeOne.employee.repository;

import com.employeeSatgeOne.employee.entity.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository< Employee, Integer> {

}
