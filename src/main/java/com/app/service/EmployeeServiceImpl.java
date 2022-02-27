package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepostory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepostory employeeRepostory;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepostory.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee result = null;
		if (id != null) {
			result = employeeRepostory.findById(id).get();
		}
		return result;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee result = null;
		if (employee != null) {
			result = employeeRepostory.save(employee);
		}
		return result;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		if (id != null) {
			employeeRepostory.deleteById(id);
		}
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee result = null;
		if (employee != null) {
			result = employeeRepostory.save(employee);
		}
		return result;
	}

}
