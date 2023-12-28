package com.infra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infra.entity.Employee;
import com.infra.repo.EmployeeRepository;
import com.infra.serviceInterface.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository er;

	@Override
	public Employee saveEmployee(Employee e) {
		return er.save(e);
	}

	@Override
	public void deleteEmployee(Employee e) {
		er.delete(e);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return er.findAll();
	}

	@Override
	public Employee getById(int id) {
		Optional<Employee> e =  er.findById(id);
		return e.isPresent()==false ? null: e.get();
	}
}
