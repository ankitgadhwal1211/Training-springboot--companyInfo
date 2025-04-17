package com.siddhatech.companyInfo.service.impl;

import com.siddhatech.companyInfo.dto.EmployeeDto;
import com.siddhatech.companyInfo.entity.Employee;
import com.siddhatech.companyInfo.exception.EmployeeNotFoundException;
import com.siddhatech.companyInfo.repository.EmployeeJpaRepositroy;
import com.siddhatech.companyInfo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeJpaRepositroy repositroy;

    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = repositroy.findAll();
        return ResponseEntity.ok(employeeList);
    }
    public ResponseEntity<Employee> getEmployee(Long id){
        Employee employee = repositroy.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found"));
        return ResponseEntity.ok(employee);
    }

    public String addEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        repositroy.save(employee);
        return "Employee saved";
    }

    public String updateEmployee(Long id, EmployeeDto employeeDto){
        Employee employee = repositroy.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        repositroy.save(employee);
        return "Employee delete";
    }

    public String deleteEmployee(Long id){
        Employee employee = repositroy.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        repositroy.deleteById(id);
        return "Employee Deleted";
    }
    @Override
    @Transactional
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(Long id) {
        List<Employee> listEmployee = repositroy.GetEmployeesByDepartment(id);
        return ResponseEntity.ok(listEmployee);
    }

    public ResponseEntity<List<Employee>> findBySalary(Double salary){
        List<Employee> employeeList = repositroy.findEmployeeBySalary(salary);
        return ResponseEntity.ok(employeeList);
    }
    public ResponseEntity<List<Employee>> showBySalary(Double salary){
        List<Employee> employeeList = repositroy.showEmployeeBySalary(salary);
        return ResponseEntity.ok(employeeList);
    }

    public Long countEmployee(Long id){
        return repositroy.countEmployeeByDepartment(id);
    }
}
