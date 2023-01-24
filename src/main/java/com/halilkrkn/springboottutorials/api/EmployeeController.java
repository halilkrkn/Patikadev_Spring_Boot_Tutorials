package com.halilkrkn.springboottutorials.api;

import com.halilkrkn.springboottutorials.data.dto.EmployeeDto;
import com.halilkrkn.springboottutorials.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeServices employeeServices;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    //List
    // http://localhost:8080/api/v1/employess
    @GetMapping("/employess")
    public List<EmployeeDto> getAllEmployess() {
        List<EmployeeDto> employeeDtosList = employeeServices.getAllEmployees();
        return employeeDtosList;
    }

    // Find
    // http://localhost:8080/api/v1/employess/1
    @GetMapping("/employess/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employeeById = employeeServices.getEmployeeById(id);
        return ResponseEntity.ok(employeeById);
    }

    // Save
    // http://localhost:8080/api/v1/employess/insert
    @PostMapping("/employess/insert")
    public ResponseEntity<EmployeeDto> getInsertEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto insertEmployee = employeeServices.createEmployee(employeeDto);
        return ResponseEntity.ok(insertEmployee);
    }

    // Update
    // http://localhost:8080/api/v1/employess/insert
    @PutMapping("/employess/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updateEmployee = employeeServices.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(updateEmployee);
    }

    // Delete
    @DeleteMapping("/employess/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id)  {
        employeeServices.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
