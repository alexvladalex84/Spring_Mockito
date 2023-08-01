package com.example.spring_makito_employeebook.Instance.Service;

import com.example.spring_makito_employeebook.Exception.EmployeeNotFoundException;
import com.example.spring_makito_employeebook.Instance.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private Collection<Employee> getAllWorkers() {
        return employeeService.getAllWorkers();
    }


    @Override
    public List<Employee> getAllByDepartmentId(int id) {
        employeeService.minMaxNumberOfDepartments(id);
        return getAllWorkers().stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());

    }

    @Override
    public int getTotalSalaryByDepartment(int id) {
        employeeService.minMaxNumberOfDepartments(id);
        List<Employee> employees = (List<Employee>) getAllWorkers();
        return employees.stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(e -> e.getSalary()).sum();


    }


    @Override
    public Employee getMaxSalaryByDepartment(int id) {
        employeeService.minMaxNumberOfDepartments(id);
        List<Employee> employees = (List<Employee>) getAllWorkers();
        return employees.stream()
                .filter(e -> e.getDepartment() == id)
                .max(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public Employee getMinSalaryByDepartment(int id) {
        employeeService.minMaxNumberOfDepartments(id);
        List<Employee> employees = (List<Employee>) getAllWorkers();
        return employees.stream()
                .filter(e -> e.getDepartment() == id)
                .min(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return getAllWorkers().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.toList()));

    }

//    private Stream<Employee> streamByDepartment(Integer id) {
//        List<Employee> employees = (List<Employee>) employeeService.getAllWorkers();
//        return employees.stream()
//                .filter(e->id == null || e.getDepartment().e)

//    }
}/* public Map<Integer, List<Employee>> getAllByDepartment(Integer departmentId) {
       Map<Integer, List<Employee>> employeeMap = new HashMap<>();
        List<Employee> employeesList = (List<Employee>) getAllWorkers();
        List<Employee> dprList = new ArrayList<>();

        for (Employee e : employeesList) {
           Integer key = e.getDepartment();
            if (key == e.getDepartment()) {
                Employee employee = new Employee(e.getFirstName(),e.getLastName(),e.getSalary(),e.getDepartment());
                dprList.add(employee);
            }
            employeeMap.put(key,dprList);
        }

        return employeeMap;

*/
