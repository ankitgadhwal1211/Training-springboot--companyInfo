package com.siddhatech.companyInfo.repository;

import com.siddhatech.companyInfo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeJpaRepositroy extends JpaRepository<Employee,Long> {
    //using name as procedure name
    @Transactional(readOnly = true)
    @Procedure
    List<Employee> GetEmployeesByDepartment(Long id);
    //using value as procedure name with different method name
    @Procedure(value = "GetEmployeesByDepartment")
    List<Employee> getEmpsByDept(Long id);

    //using named Stored Procedure Queries with different method name
    @Procedure(name = "GetEmployeesByDepartment")
    List<Employee> getEmpsByDepts(@Param("id") Long id);



    @Query(name = "showBySalary")
    List<Employee> findEmployeeBySalary(Double salary);

    @Query(name = "showEmployeeBySalary",nativeQuery = true)
    List<Employee> showEmployeeBySalary(Double salary);

    @Query(name = "countEmployeeByDepartment",nativeQuery = true)
    Long countEmployeeByDepartment(Long department_id);




}
