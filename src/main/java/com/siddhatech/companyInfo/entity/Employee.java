package com.siddhatech.companyInfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.type.ProcedureParameterNamedBinder;
import org.hibernate.type.Type;
import org.springframework.data.jpa.repository.query.Procedure;

import javax.security.auth.login.Configuration;
import java.time.LocalDate;

@Entity
@NamedStoredProcedureQuery(
        name = "getEmpsByDepts",
        procedureName = "GetEmployeesByDepartment",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class)
        }
)
@NamedQuery(
        name = "showBySalary",
        query = "From Employee e Where e.salary < :salary"
)
@NamedNativeQuery(
        name = "showEmployeeBySalary",
        query = "Select * From Employee e Where e.salary < ?",
        resultClass = Employee.class
)
@NamedNativeQuery(
        name = "countEmployeeByDepartment",
        query = "Select count(*) From Employee e Where e.department_id = ?"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Double salary;
    private LocalDate hireDate;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(){
    }

    public Employee(Long id, String firstName, String lastName, String email, String phoneNumber, Double salary, LocalDate hireDate, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}


