package com.halilkrkn.springboottutorials.data.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


// DTO = Data Transfer Object - Entity'de oluşturduğumuz yapıları buraya yazıyoruz ki ilgili class'lar doğrudan bu DTO class'ımız ile ilgilensin.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
