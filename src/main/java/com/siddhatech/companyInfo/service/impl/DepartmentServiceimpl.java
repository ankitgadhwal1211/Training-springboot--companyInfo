package com.siddhatech.companyInfo.service.impl;
import com.siddhatech.companyInfo.entity.Department;
import com.siddhatech.companyInfo.exception.DepartmentNotFoundException;
import com.siddhatech.companyInfo.repository.DepartmentJpaRepository;
import com.siddhatech.companyInfo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceimpl implements DepartmentService {
    @Autowired
    private DepartmentJpaRepository repositroy;

    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departmentList = repositroy.findAll();
        return ResponseEntity.ok(departmentList);
    }
    public ResponseEntity<Department> getDepartment(Long id){
        Department department = repositroy.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found"));
        return ResponseEntity.ok(department);
    }
}
