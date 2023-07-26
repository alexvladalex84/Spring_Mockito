package com.example.spring_makito_employeebook.Instance.Service;

public interface EmployeeService {
    String addWorkers(String surName, String name, int salary, int department);

    String removeTheWorker(int ID);

    void getAllWorkers();

}
