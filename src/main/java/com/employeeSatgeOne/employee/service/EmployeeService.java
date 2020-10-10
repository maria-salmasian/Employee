package com.employeeSatgeOne.employee.service;

import com.employeeSatgeOne.employee.entity.Employee;
import com.employeeSatgeOne.employee.exceptions.NotFoundException;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees() throws NotFoundException;
    Employee getEmployeeByID(int id) throws NotFoundException;
    Employee saveEmployee(Employee employee) throws NotFoundException;
    Employee updateEmployeeByID(int id, Employee employee) throws NotFoundException;
    void deleteEmployeeByID(int id) throws NotFoundException;
}
