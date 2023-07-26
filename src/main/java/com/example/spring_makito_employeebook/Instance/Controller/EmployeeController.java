package com.example.spring_makito_employeebook.Instance.Controller;

import com.example.spring_makito_employeebook.Instance.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    private final EmployeeService serviceEmployee;

    public EmployeeController(EmployeeService serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping("/add")
    public String addWorkers(String surName, String name, int salary, int department) {
        return serviceEmployee.addWorkers(surName, name, salary, department);
    }

    @GetMapping("/remove")
    public String removeTheWorker(int ID) {
        return serviceEmployee.removeTheWorker(ID);
    }

    @GetMapping
    public void getAllWorkers() {
        serviceEmployee.getAllWorkers();
    }

}
