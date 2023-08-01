package com.example.spring_makito_employeebook.Instance.Service;

import com.example.spring_makito_employeebook.Instance.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getAllByDepartmentId(int id);

    int getTotalSalaryByDepartment(int id);

    Employee getMaxSalaryByDepartment(int id);

    Employee getMinSalaryByDepartment(int id);

    Map<Integer, List<Employee>> getEmployeesGroupedByDepartment();

}
