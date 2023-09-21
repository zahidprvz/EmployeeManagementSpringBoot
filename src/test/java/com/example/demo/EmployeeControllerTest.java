package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class) // Use MockitoExtension for JUnit 5
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeManager employeeManager;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetEmployees() throws Exception {
        // Create a list of mock employees
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(1, "John", "Doe", "john@example.com", "Manager"));

        // Mock behavior of the employeeManager
        Mockito.when(employeeManager.getAllEmployees()).thenReturn(new Employees(mockEmployeeList));

        mockMvc.perform(get("/employees/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.employeeList[0].first_name").value("John"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee newEmployee = new Employee(null, "Jane", "Smith", "jane@example.com", "Engineer");

        // Mock behavior of the employeeManager
        Mockito.when(employeeManager.getAllEmployees()).thenReturn(new Employees(new ArrayList<>()));

        // Mock behavior of the employeeManager when adding an employee
        Mockito.doAnswer(invocation -> {
            List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
            int newId = employees.size() + 1;
            newEmployee.setId(newId);
            employees.add(newEmployee);
            return null;
        }).when(employeeManager).addEmployee(Mockito.any(Employee.class));

        mockMvc.perform(post("/employees/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"first_name\":\"Jane\",\"last_name\":\"Smith\",\"email\":\"jane@example.com\",\"title\":\"Engineer\"}"))
                .andExpect(status().isCreated());

        // Verify that the employee was added
        mockMvc.perform(get("/employees/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.employeeList[1].first_name").value("Jane"));
    }
}
