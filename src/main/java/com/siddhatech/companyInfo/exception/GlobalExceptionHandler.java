package com.siddhatech.companyInfo.exception;

import com.siddhatech.companyInfo.CompanyInfoApplication;
import com.siddhatech.companyInfo.service.impl.DepartmentServiceimpl;
import com.siddhatech.companyInfo.service.impl.EmployeeServiceimpl;
//import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
//@Slf4j
public class GlobalExceptionHandler {

    private static final Logger employeeServiceLogger = LoggerFactory.getLogger(EmployeeServiceimpl.class);
    private static final Logger departmentServiceLogger = LoggerFactory.getLogger(DepartmentServiceimpl.class);
    //private static final Logger unexpectedLogger = LoggerFactory.getLogger(CompanyInfoApplication.class);

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> employeeNotFoundExceptionHandler(EmployeeNotFoundException e){
        employeeServiceLogger.error("EmployeeNotFoundException: {}",e.getMessage(),e);
        ResponseError response = new ResponseError(LocalDateTime.now(), e.getMessage(),"Employee is Not Available");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> departmentNotFoundExceptionHandler(DepartmentNotFoundException e){
        departmentServiceLogger.error("DepartmentNotFoundException: {}",e.getMessage(),e);
        ResponseError response = new ResponseError(LocalDateTime.now(), e.getMessage(),"Department is Not Available");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> globalExceptionHandler(Exception e) {
//        unexpectedLogger.error("Unexpected error: {}", e.getMessage(), e);
//        ResponseError response = new ResponseError(LocalDateTime.now(), "Internal Server Error", "Something went wrong");
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
