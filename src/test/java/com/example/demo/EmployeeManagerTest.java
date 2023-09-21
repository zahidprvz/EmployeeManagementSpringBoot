package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class) // Use MockitoExtension for JUnit 5
public class EmployeeManagerTest {

    @InjectMocks
    private EmployeeManager employeeManager;

    @Mock
    private Employees employees;

    @BeforeEach
    public void setup() {
        // No need for MockitoAnnotations.initMocks(this)
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(1, "John", "Doe", "john@example.com", "Manager"));

        when(employees.getEmployeeList()).thenReturn(mockEmployeeList);

        assertEquals(employees, employeeManager.getAllEmployees());
    }

    @Test
    public void testAddEmployee() {
        List<Employee> mockEmployeeList = new ArrayList<>();
        when(employees.getEmployeeList()).thenReturn(mockEmployeeList);

        Employee newEmployee = new Employee(null, "Jane", "Smith", "jane@example.com", "Engineer");

        employeeManager.addEmployee(newEmployee);

        assertEquals(1, mockEmployeeList.size());
        Employee addedEmployee = mockEmployeeList.get(0);
        assertEquals("Jane", addedEmployee.getFirstName());
        assertEquals("Smith", addedEmployee.getLastName());
        assertEquals("jane@example.com", addedEmployee.getEmail());
        assertEquals("Engineer", addedEmployee.getTitle());
    }
}
