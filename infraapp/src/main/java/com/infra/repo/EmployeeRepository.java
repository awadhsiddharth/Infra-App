package com.infra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infra.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
