package com.siddhatech.companyInfo.service;

import com.siddhatech.companyInfo.dto.EmployeeDto;
import com.siddhatech.companyInfo.entity.Employee;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<List<Employee>> getAllEmployees();
    ResponseEntity<Employee> getEmployee(Long id);
    String addEmployee(EmployeeDto employeeDto);
    String updateEmployee(Long id, EmployeeDto employeeDto);
    String deleteEmployee(Long id);
    ResponseEntity<List<Employee>>  getEmployeesByDepartment(Long id);

    ResponseEntity<List<Employee>> findBySalary(Double salary);
    ResponseEntity<List<Employee>> showBySalary(Double salary);
    Long countEmployee(Long id);
}
