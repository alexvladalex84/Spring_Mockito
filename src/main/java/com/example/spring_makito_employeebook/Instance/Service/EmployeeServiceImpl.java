package com.example.spring_makito_employeebook.Instance.Service;

import com.example.spring_makito_employeebook.Exception.ArrayIsFullException;
import com.example.spring_makito_employeebook.Exception.InvalidNameException;
import com.example.spring_makito_employeebook.Exception.NumberDepartmentException;
import com.example.spring_makito_employeebook.Instance.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final int MAX_NUMBER_DEPARTMENT = 5;

    private final int AMOUNT_WORKERS = 10;
    private final List<Employee> employees = new ArrayList<>();

    public int getAMOUNT_WORKERS() {
        return AMOUNT_WORKERS;
    }

    @Override

    public String addWorkers(String firstName, String lastName, int salary, int department) {
        if (employees.size() > AMOUNT_WORKERS) {
            throw new NumberDepartmentException("Привышен лимит количества сотрудников!");
        }
        minMaxNumberOfDepartments(department);
        Employee employee = new Employee(firstName, lastName, salary, department);
        checkingForEmptyStrings(firstName, lastName);
        checkUpperCase(firstName, lastName);
        checkAlpha(firstName, lastName);
        if (employees.contains(employee)) {
            throw new ArrayIsFullException("Попытка добавить уже существующего сотрудника!");
        }
        employees.add(employee);
        if (!employees.contains(employee)) {
            throw new ArrayIsFullException("Сотрудник не добавлен");
        }
        return "Сотрудник " + employee + " добавлен!";

    }

    @Override
    public String findWorker(String firstName, String lastName, int salary, int department) {
        checkingForEmptyStrings(firstName, lastName);
        checkUpperCase(firstName, lastName);
        checkAlpha(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            return "Сотрудник " + String.valueOf(employee) + " найден";
        }
        throw new ArrayIsFullException("Сотрудника с таким именем или фамилией не существует!");
    }

    @Override
    public String removeTheWorker(String firstName, String lastName, int salary, int department) {
        checkingForEmptyStrings(firstName, lastName);
        checkUpperCase(firstName, lastName);
        checkAlpha(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return "Сотрудник " + employee + " удален!";
        }

        throw new ArrayIsFullException("Сотрудника с таким именем или фамилией не существует!");

    }


    @Override
    public Collection<Employee> getAllWorkers() {
        return employees;
    }

    @Override
    public int minMaxNumberOfDepartments(int departmentId) {
        if (departmentId <= 0 || departmentId > MAX_NUMBER_DEPARTMENT) {
            throw new NumberDepartmentException("Такого номера департамента не существует!");
        }
        return departmentId;
    }

    private void checkingForEmptyStrings(String firstName, String lastName) {
        if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName)) {
            throw new ArrayIsFullException("Строки фио не заполнены");
        }
    }

    private void checkUpperCase(String firstName, String lastName) {
        String firstNameInUpperCase = StringUtils.capitalize(firstName);
        String lastNameInUpperCase = StringUtils.capitalize(lastName);

        if (!firstNameInUpperCase.equals(firstName)) {
            throw new InvalidNameException("Имя не с заглавной буквы");
        }
        if (!lastNameInUpperCase.equals(lastName)) {
            throw new InvalidNameException("Фамилия не с заглавной буквы");
        }

    }

    private void checkAlpha(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidNameException("Имя содержит запрещенные знаки");
        }
        if (!StringUtils.isAlpha(lastName)) {
            throw new InvalidNameException("Фамилия содержит запрещенные знаки");
        }
    }

}
