package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    private List<Employee> employeeList;

    // Default constructor
    public Employees() {
    }

    // Constructor that accepts a List<Employee>
    public Employees(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    // Getter and setter methods for employeeList
    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
