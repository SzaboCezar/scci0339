package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    private EmployeeMock empMock;
    @BeforeEach
    void setUp() {
        empMock = new EmployeeMock();
    }

    @AfterEach
    void tearDown() {
        empMock = null;
    }

    @Test
    void addEmployee_AllValid() {
        Employee emp = new Employee("Ion", "Pop", "5432424242222", DidacticFunction.ASISTENT, 5000d);
        empMock.addEmployee(emp);
        assertTrue(empMock.getEmployeeList().contains(emp));
    }

    @Test
    void addEmployee_firstNameInvalid() {
        Employee emp = new Employee("Io!!!", "Pop", "5432424242222", DidacticFunction.ASISTENT, 5000d);
        empMock.addEmployee(emp);
        assertFalse(empMock.getEmployeeList().contains(emp));
    }

    @Test
    void addEmployee_salaryInvalid() {
        Employee emp = new Employee("Ion", "Pop", "5432424242222", DidacticFunction.ASISTENT, 0.0);
        empMock.addEmployee(emp);
        assertFalse(empMock.getEmployeeList().contains(emp));
    }

    @Test
    void addEmp_CNPInvalid() {
        Employee emp = new Employee("Ion", "Pop", "543242424222", DidacticFunction.ASISTENT, 5000d);
        empMock.addEmployee(emp);
        assertFalse(empMock.getEmployeeList().contains(emp));
    }




    @Test
    void validModifyEmployeeFunction_should_save() {
        Employee Ionel = empMock.getEmployeeList().get(0);
        empMock.modifyEmployeeFunction(Ionel, DidacticFunction.LECTURER);
        Employee modifiedIonel = empMock.getEmployeeList().get(0);
        assertEquals(DidacticFunction.LECTURER, modifiedIonel.getFunction());
    }

    @Test
    void invalidModifyEmployeeFunction_should_notSave() {
        Employee Test = null;
        List<Employee> beforeList = empMock.getEmployeeList();

        empMock.modifyEmployeeFunction(Test, DidacticFunction.LECTURER);
        List<Employee> afterList = empMock.getEmployeeList();

        assertIterableEquals(beforeList, afterList);
    }

    @Test
    void filterEmployeesByDidacticFunction() {
        EmployeeMock empMock = new EmployeeMock();
        Employee emp1 = new Employee("Ion", "Pop", "5432424242222", DidacticFunction.ASISTENT, 5000d);
        Employee emp2 = new Employee("Maria", "Ionescu", "5432424243333", DidacticFunction.TEACHER, 7000d);
        Employee emp3 = new Employee("Andrei", "Mihai", "5432424244444", DidacticFunction.LECTURER, 6000d);
        empMock.addEmployee(emp1);
        empMock.addEmployee(emp2);
        empMock.addEmployee(emp3);

        DidacticFunction targetFunction = DidacticFunction.ASISTENT;

        List<Employee> filteredEmployees = empMock.getEmployeeList().stream()
                .filter(employee -> employee.getFunction()== targetFunction)
                .collect(Collectors.toList());

        for (Employee employee : filteredEmployees) {
            System.out.println(employee);
            assertEquals(targetFunction, employee.getFunction());
        }
    }
}