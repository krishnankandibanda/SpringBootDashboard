package com.app.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.app.model.Employee;
import com.app.repository.EmployeeRepostory;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceMockTest {

	@Mock
	EmployeeRepostory employeeRepostory;

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetEmployeeById() {
		Integer employeeId = 101;
		Optional<Employee> expectedEmployee = Optional.of(createEmployee(employeeId, "Srini", "Lead Engineer"));
		when(employeeRepostory.findById(employeeId)).thenReturn(expectedEmployee);

		Employee actualEmployee = employeeServiceImpl.getEmployeeById(employeeId);

		verify(employeeRepostory).findById(employeeId);
		assertEquals(expectedEmployee.get().getEmpid(), actualEmployee.getEmpid());
		assertEquals(expectedEmployee.get().getEname(), actualEmployee.getEname());
		assertEquals(expectedEmployee.get().getJob(), actualEmployee.getJob());
	}

	@Test
	public void testGetEmployeeByIdWithNull() {
		Integer employeeId = null;

		Employee actualEmployee = employeeServiceImpl.getEmployeeById(employeeId);

		assertNull(actualEmployee);
	}

	@Test
	public void testDeleteEmployeeById() {
		Integer employeeId = 105;

		doNothing().when(employeeRepostory).deleteById(employeeId);

		employeeServiceImpl.deleteEmployeeById(employeeId);

		verify(employeeRepostory).deleteById(employeeId);

	}

	@Test
	public void testDeleteEmployeeByIdWithNull() {
		Integer employeeId = null;

		employeeServiceImpl.deleteEmployeeById(employeeId);
	}

	@Test
	public void testSaveEmployee() {

		Employee expectedEmployee = createEmployee(105, "Srini", "Lead Engineer");
		when(employeeRepostory.save(expectedEmployee)).thenReturn(expectedEmployee);

		Employee actualEmployee = employeeServiceImpl.saveEmployee(expectedEmployee);

		verify(employeeRepostory).save(expectedEmployee);
		assertEquals(expectedEmployee.getEmpid(), actualEmployee.getEmpid());
		assertEquals(expectedEmployee.getEname(), actualEmployee.getEname());
		assertEquals(expectedEmployee.getJob(), actualEmployee.getJob());

	}

	@Test
	public void testSaveEmployeeWithNUll() {
		Employee employee = null;

		Employee actualEmployee = employeeServiceImpl.saveEmployee(employee);

		assertNull(actualEmployee);

	}

	@Test
	public void testUpdateEmployee() {

		Employee expectedEmployee = createEmployee(101, "Srini", "Lead Engineer");
		when(employeeRepostory.save(expectedEmployee)).thenReturn(expectedEmployee);

		Employee actualEmployee = employeeServiceImpl.updateEmployee(expectedEmployee);

		verify(employeeRepostory).save(expectedEmployee);
		assertEquals(expectedEmployee.getEmpid(), actualEmployee.getEmpid());
		assertEquals(expectedEmployee.getEname(), actualEmployee.getEname());
		assertEquals(expectedEmployee.getJob(), actualEmployee.getJob());
	}

	@Test
	public void testUpdateEmployeeWithNUll() {
		Employee employee = null;

		Employee actualEmployee = employeeServiceImpl.updateEmployee(employee);

		assertNull(actualEmployee);
	}

	@Test
	public void testGetAllEmployees() {
		// Initialization or setup
		List<Employee> expectedEmployees = createEmployees();
		when(employeeRepostory.findAll()).thenReturn(expectedEmployees);

		// run
		List<Employee> actualEmployees = employeeServiceImpl.getAllEmployees();

		// verify
		verify(employeeRepostory).findAll();
		assertEquals(expectedEmployees.size(), actualEmployees.size());

	}

	private List<Employee> createEmployees() {
		List<Employee> result = new ArrayList<Employee>();

		result.add(createEmployee(101, "Krishna", "SoftwareEngineer"));
		result.add(createEmployee(102, "Srinivas", "SoftwareEngineer"));
		result.add(createEmployee(103, "Pradeep", "SoftwareEngineer"));
		result.add(createEmployee(104, "Sathish", "SoftwareEngineer"));
		result.add(createEmployee(105, "Rama", "SoftwareEngineer"));

		return result;
	}

	private Employee createEmployee(Integer empId, String ename, String job) {
		Employee result = new Employee();
		result.setEmpid(empId);
		result.setEname(ename);
		result.setJob(job);
		return result;
	}

}