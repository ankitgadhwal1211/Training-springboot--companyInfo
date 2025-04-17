package com.siddhatech.companyInfo.repository;

import com.siddhatech.companyInfo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentJpaRepository extends JpaRepository <Department,Long>{
}
