package com.example.spring_makito_employeebook.Instance.Service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public String addWorkers(String surName, String name, int salary, int department) {

        return surName;
    }

    @Override
    public String removeTheWorker(int ID) {

        return null;
    }

    @Override
    public void getAllWorkers() {

    }
}
