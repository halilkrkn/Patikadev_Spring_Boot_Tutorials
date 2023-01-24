package com.halilkrkn.springboottutorials.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


// Base olarak kullanılan yapıları buraya yazdık. Çünkü tüm proje için ortak yapılar.

//Lombok
@Getter
@Setter
//Hibernate JPA
@MappedSuperclass
//Auditing
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date,update_date"}, allowGetters = true)
public class BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;

    @Column(name = "upadate_by")
    @LastModifiedBy
    private String upadateBy;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;

    @Column(name = "system_auto_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
}
