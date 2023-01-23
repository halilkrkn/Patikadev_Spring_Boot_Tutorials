package com.halilkrkn.springboottutorials.service;

import com.halilkrkn.springboottutorials.data.dto.EmployeeDto;
import com.halilkrkn.springboottutorials.data.entities.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    // CRUD (Create, Read ,Update, Delete) İşlemleri için gereken methodlar
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto);
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id);


    // Model Mapper
    public  EmployeeDto entityToDto(EmployeeEntity employeeEntity);
    public  EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
}
