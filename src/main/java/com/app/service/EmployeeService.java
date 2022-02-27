package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Integer id);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Integer id);

	Employee saveEmployee(Employee employee);

}
