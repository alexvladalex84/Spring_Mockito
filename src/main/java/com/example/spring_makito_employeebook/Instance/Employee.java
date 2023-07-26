package com.example.spring_makito_employeebook.Instance;

import java.util.Objects;

public class Employee {
    public static int idCounter = 0;
    private final int id;
    private String surName;
    private String name;
    private int salary;
    private int department;

    public Employee(String surName, String name, int salary, int department) {
        this.surName = surName;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.id = idCounter++;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Employee.idCounter = idCounter;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && department == employee.department && Objects.equals(surName, employee.surName) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surName, name, salary, department);
    }
}
