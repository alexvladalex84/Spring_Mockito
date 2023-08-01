package com.example.spring_makito_employeebook.Instance.Controller;

import com.example.spring_makito_employeebook.Instance.Employee;
import com.example.spring_makito_employeebook.Instance.Service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employee")
    public List<Employee> getAllByDepartmentId(@PathVariable int id) {
        return departmentService.getAllByDepartmentId(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getTotalSalaryByDepartment(@PathVariable int id) {
        return departmentService.getTotalSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public Employee getMaxSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getMinSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMinSalaryByDepartment(id);
    }

    @GetMapping()
    public Map<Integer,List<Employee>> getAllByDepartmentId() {
       return  departmentService.getEmployeesGroupedByDepartment();
    }

}
