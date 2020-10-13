package com.employeeSatgeOne.employee.controller;

import com.employeeSatgeOne.employee.entity.Employee;
import com.employeeSatgeOne.employee.exceptions.NotFoundException;
import com.employeeSatgeOne.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;


    /**
     *
     * @return
     * @throws NotFoundException
     */
    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() throws NotFoundException {
        List<Employee> planetList = employeeService.getEmployees();
        return new ResponseEntity<>(planetList, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")  int id) throws NotFoundException {
        Employee employee = employeeService.getEmployeeByID(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    /**
     *
     * @param employee
     * @return
     * @throws NotFoundException
     */
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(
            @RequestBody   Employee employee) throws NotFoundException {
        Employee savedEmp = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }


    /**
     *
     * @param id
     * @param employee
     * @return
     * @throws NotFoundException
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(
            @PathVariable("id")  int id,
            @RequestBody  Employee employee) throws NotFoundException {
        employee.setId(id);
        Employee updated
                = employeeService.updateEmployeeByID(id, employee);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }


    /**
     *
     * @param id
     * @return
     * @throws NotFoundException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(
            @PathVariable("id")  int id) throws NotFoundException {
        employeeService.deleteEmployeeByID(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
