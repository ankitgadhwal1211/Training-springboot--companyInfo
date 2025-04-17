package com.siddhatech.companyInfo.service;

import com.siddhatech.companyInfo.entity.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    ResponseEntity<List<Department>> getAllDepartment();
    ResponseEntity<Department> getDepartment(Long id);
}
