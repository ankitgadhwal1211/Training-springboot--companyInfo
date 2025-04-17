package com.siddhatech.companyInfo.controller;

import com.siddhatech.companyInfo.entity.Department;
import com.siddhatech.companyInfo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @GetMapping("/")
    public ResponseEntity<List<Department>> getAllDepartment(){
         return service.getAllDepartment();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id){
        return service.getDepartment(id);
    }
}
