package com.halilkrkn.springboottutorials.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.halilkrkn.springboottutorials.data.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


// Register (kayıt olma) için kullanılır.
//Lombok
@Getter
@Setter
//JPA
@Entity
@Table(name = "user")
public class _2_UserEntity extends BaseEntity {

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "system_aute_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
}
