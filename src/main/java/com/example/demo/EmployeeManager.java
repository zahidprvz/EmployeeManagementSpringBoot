package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
// Class to create a list
// of employees
public class EmployeeManager {

    private static Employees list = new Employees();


    // Method to return the list
    public Employees getAllEmployees() {

        return list;
    }

    // Method to add an employee
    // to the employees list
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
