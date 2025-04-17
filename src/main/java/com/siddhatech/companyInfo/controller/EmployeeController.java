package com.siddhatech.companyInfo.controller;

import com.siddhatech.companyInfo.dto.EmployeeDto;
import com.siddhatech.companyInfo.entity.Employee;
import com.siddhatech.companyInfo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return service.getEmployee(id);
    }

    @PostMapping("/")
    public String addEmployee(@RequestBody EmployeeDto employeeDto){
        return service.addEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public String updateEmployeeByID(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return service.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return service.deleteEmployee(id);
    }

    @GetMapping("/By-Department/{id}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@PathVariable Long id){
        return service.getEmployeesByDepartment(id);
    }

    @GetMapping("/By-Salary/")
    public ResponseEntity<List<Employee>> findEmployeesBySalary(@RequestBody Double salary){
        return service.findBySalary(salary);
    }
    @GetMapping("/by-salary/")
    public ResponseEntity<List<Employee>> showEmployeesBySalary(@RequestBody Double salary){
        return service.showBySalary(salary);
    }
    @GetMapping("/by-department/{id}")
    public Long countEmployeesByDepartment(@PathVariable Long id){
        return service.countEmployee(id);
    }


}
