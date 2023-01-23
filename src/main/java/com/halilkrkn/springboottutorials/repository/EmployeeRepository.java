package com.halilkrkn.springboottutorials.repository;


// ORM yapılarını kullandığımız yer burasıdır.
// Yani burası Data Access Layer Katmanıdır.
// JPA, Hibernate ile ilgili yapıları/işlemleri buraya yazıyoruz.
// JpaRepository, CrudRepository gibi class'lardan birisini extend ederek ilgili işlemleri yapabiliriz.
// Ama JpaRepository > CrudRepository'den daha geniş bir işlevsellik sağlar.

import com.halilkrkn.springboottutorials.data.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
