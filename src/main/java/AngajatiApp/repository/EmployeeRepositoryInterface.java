package AngajatiApp.repository;

import java.util.List;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;

public interface EmployeeRepositoryInterface {

	void addEmployee(Employee employee);
	void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction);
	List<Employee> getEmployeeList();
	List<Employee> sortEmployeeByAgeAndSalaryCriteria();
	Employee findEmployeeById(int idOldEmployee);

}

