package com.infra.serviceInterface;

import java.util.List;

import com.infra.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee e);
	void deleteEmployee(Employee e);
	List<Employee> getAllEmployee();
	Employee getById(int id);
}
