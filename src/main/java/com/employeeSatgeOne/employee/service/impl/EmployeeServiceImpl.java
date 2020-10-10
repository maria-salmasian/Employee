package com.employeeSatgeOne.employee.service.impl;

import com.employeeSatgeOne.employee.entity.Employee;
import com.employeeSatgeOne.employee.exceptions.NotFoundException;
import com.employeeSatgeOne.employee.repository.EmployeeRepository;
import com.employeeSatgeOne.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public LinkedList<Employee> getEmployees() throws NotFoundException {
        LinkedList<Employee> listEmp=new LinkedList<>();
        employeeRepository.findAll().forEach(listEmp::add);
        if (!listEmp.isEmpty())
        return listEmp;
        else throw new NotFoundException("No employees found");
    }

    @Override
    public Employee getEmployeeByID(int id) throws NotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found for this id :: " + id));
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) throws NotFoundException {
        if (employee != null)
            return employeeRepository.save(employee);
        else throw new NotFoundException("employee not found to be saved");
    }


    @Override
    public Employee updateEmployeeByID(int id, Employee initEmployee) throws NotFoundException {
        Employee employeeDB = employeeRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Employee not found for this id :: " + id));

        employeeDB.setId(initEmployee.getId());
        employeeDB.setName(initEmployee.getName());
        employeeDB.setSurname(initEmployee.getSurname());
        employeeDB.setId(initEmployee.getId());
        employeeDB.setEmail(initEmployee.getEmail());
        employeeDB.setAge(initEmployee.getAge());
        return employeeRepository.save(employeeDB);


    }

    @Override
    public void deleteEmployeeByID(int id) throws NotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found for this id :: " + id));
        employeeRepository.deleteById(employee.getId());
    }


}
