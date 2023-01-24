package com.halilkrkn.springboottutorials.service;

import com.halilkrkn.springboottutorials.data.dto.EmployeeDto;
import com.halilkrkn.springboottutorials.data.entities.EmployeeEntity;
import com.halilkrkn.springboottutorials.exception.ResourceNotFoundException;
import com.halilkrkn.springboottutorials.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Burada Database ile alakalı Business Logic işlemlerini yani iş kurallarını yazıyoruz
@Service
public class EmployeeServicesImpl implements EmployeeServices {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServicesImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    // CRUD İşlemleri
    //List İşlemi
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity: employeeEntities) {
            EmployeeDto employeeDto = entityToDto(employeeEntity); // ModelMapper Yapısı
            listDto.add(employeeDto);

        }
        return listDto;
    }

    // Save İşlemi
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto); // ModelMapper Yapısı
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    // Find İşlemi
    @Override
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
        EmployeeDto employeeDto = entityToDto(employeeEntity); // ModelMapper Yapısı
        return employeeDto;
    }

    // Update İşlemi
    @Override
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto); // ModelMapper Yapısı
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id"+ id));
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmail(employeeEntity.getEmail());

        EmployeeEntity updateEmployee = employeeRepository.save(employee);
        EmployeeDto updateEmployeeDto = entityToDto(updateEmployee);

        return updateEmployeeDto;
    }

    // Delete İşlemi
    @Override
    public Map<String, Boolean> deleteEmployee(@PathVariable Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id"+ id));
        employeeRepository.delete(employeeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    // Model Mapper İşlemleri
    // Model Mapper'ı kullanarak, Entity'den => DTO 'ya çevirme işlemini yaptık.
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        // Burada ModelMapper'ı kullanarak employeeEntity yapısından EmployeeDto yapısına çeviriyoruz.
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    // Model Mapper'ı kullanarak, DTO'dan => Entity'e çevirme işlemini yaptık.
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        // Burada ModelMapper'ı kullanarak employeeDto yapısından EmployeeEntity yapısına çeviriyoruz.
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        return employeeEntity;
    }
}
