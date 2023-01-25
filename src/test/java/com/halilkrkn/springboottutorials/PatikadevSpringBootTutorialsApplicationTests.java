package com.halilkrkn.springboottutorials;

import com.halilkrkn.springboottutorials.crud.TestCrud;
import com.halilkrkn.springboottutorials.data.entities.EmployeeEntity;
import com.halilkrkn.springboottutorials.repository.EmployeeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatikadevSpringBootTutorialsApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    // CREATE
    @Test
    @Override
    public void testEmployeeCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Halil Test")
                .lastName("Karkin TEst")
                .email("test@gmail.com")
                .build();

        employeeRepository.save(employeeEntity);

        // Nesne null ise assertionerror hatasını döndersin.
        assertNotNull(employeeRepository.findById(0L));
    }

    //LIST
    @Test
    @Override
    public void testEmployeeList() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        // Eğer 0'dan büyükse liste vardır.
        assertThat(employeeList).size().isGreaterThan(0);
    }

    //FIND
    @Test
    @Override
    public void testEmployeeFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        assertEquals("Halil Test", employeeEntity.getFirstName());
    }

    //UPDATE
    @Test
    @Override
    public void testEmployeeUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();

        employeeEntity.setFirstName("Halil İbrahim TEST");
        employeeRepository.save(employeeEntity);

        // Eşit Değilse bir sorun olmayacak test geçer olacak, Ama eşitse exception fırlatacak.
        assertNotEquals("Halil Test", employeeRepository.findById(1L).get().getFirstName());
    }

    //DELETE
    @Test
    @Override
    public void testEmployeeDelete() {
        employeeRepository.deleteById(1L);
        assertThat(employeeRepository.existsById(0L)).isFalse();
    }
}
