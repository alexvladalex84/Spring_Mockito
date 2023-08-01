package com.example.spring_makito_employeebook.Instance.Service;

import com.example.spring_makito_employeebook.Instance.Employee;

import java.util.Collection;

public interface EmployeeService {

    String addWorkers(String surName, String name, int salary, int department);

    String removeTheWorker(String firstName, String lastName, int salary, int department);


    String findWorker(String firstName, String lastName, int salary, int department);

    Collection<Employee> getAllWorkers();

    int minMaxNumberOfDepartments(int departmentId);
}
