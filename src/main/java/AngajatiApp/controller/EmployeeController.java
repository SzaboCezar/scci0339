package AngajatiApp.controller;

import java.util.List;

import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeImpl;
import AngajatiApp.repository.EmployeeRepositoryInterface;
import AngajatiApp.view.EmployeeView;

public class EmployeeController {
	private EmployeeImpl employeeRepository;
	private EmployeeView employeeView;
	
	public EmployeeController(EmployeeImpl employeeRepository) {
		this.employeeRepository = employeeRepository;
		this.employeeView = new EmployeeView();
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}
	
	public void modifyEmployeeFunction(Employee oldEmployee, DidacticFunction newFunction) {
		employeeRepository.modifyEmployeeFunction(oldEmployee, newFunction);
	}
	
	public List<Employee> getSortedEmployeeList() {
		return employeeRepository.sortEmployeeByAgeAndSalaryCriteria();
	}

	public Employee findEmployeeById(int idOldEmployee) {
		return employeeRepository.findEmployeeById(idOldEmployee);
	}

}
