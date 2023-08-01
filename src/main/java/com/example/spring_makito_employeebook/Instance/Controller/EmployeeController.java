package com.example.spring_makito_employeebook.Instance.Controller;

import com.example.spring_makito_employeebook.Instance.Employee;
import com.example.spring_makito_employeebook.Instance.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService serviceEmployee;

    public EmployeeController(EmployeeService serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping("/add")
    public String addWorkers(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                             @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return serviceEmployee.addWorkers(firstName,lastName, salary, department);
    }

    @GetMapping("/remove")
    public String removeTheWorker(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                  @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return serviceEmployee.removeTheWorker(firstName,lastName, salary, department);
    }
    @GetMapping("/find")
    public String findWorker(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                        @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return serviceEmployee.findWorker(firstName,lastName, salary, department);
    }

    @GetMapping
    public Collection<Employee> getAllWorkers() {
      return serviceEmployee.getAllWorkers();
    }

}
