package com.example.spring_makito_employeebook.Instance.Service;

import com.example.spring_makito_employeebook.Exception.EmployeeNotFoundException;
import com.example.spring_makito_employeebook.Instance.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Mock
    private EmployeeService employeeService;
    @Test
    void getAllByDepartmentId() {
// подготовка входных данных
        int departmentId1 = 1;

        String num1 = "Ivan";
        String num2 = "Ivanov";
        int salary = 20;
        Employee employee1 = new Employee(num1, num2, salary, departmentId1);

        String num3 = "Ivann";
        String num4 = "Ivanovv";
        int salary1 = 25;
        Employee employee2 = new Employee(num3, num4, salary1, departmentId1);

        int departmentId2 = 2;

        String num5 = "Ivannn";
        String num6 = "Ivanovvvv";
        int salary2 = 30;
        Employee employee3 = new Employee(num5, num6, salary2, departmentId2);

        String num7 = "Ivannn";
        String num8 = "Ivanovvvv";
        int salary3 = 50;
        Employee employee4 = new Employee(num7, num8, salary3, departmentId2);

// подготовка ожидаемого результата
        when(employeeService.getAllWorkers()).thenReturn(Arrays.asList(employee1,employee2,employee3,employee4));
        List<Employee> expectedList = new ArrayList<>(List.of(employee1, employee2));
//   начало теста
        List<Employee>  actualList = departmentService.getAllByDepartmentId(departmentId1);
        assertEquals(expectedList,actualList);
        assertNotEquals(departmentId1,departmentId2);
        verify(employeeService).getAllWorkers();
    }

    @Test
    void getTotalSalaryByDepartment_success() {
        // подготовка входных данных
        int departmentId1 = 1;

        String num1 = "Ivan";
        String num2 = "Ivanov";
        int salary = 21;
        Employee employee1 = new Employee(num1, num2, salary, departmentId1);

        String num3 = "Ivann";
        String num4 = "Ivanovv";
        int salary1 = 25;
        Employee employee2 = new Employee(num1, num2, salary1, departmentId1);

        int departmentId2 = 2;

        String num5 = "Ivannn";
        String num6 = "Ivanovvvv";
        int salary2 = 50;
        Employee employee3 = new Employee(num1, num2, salary2, departmentId2);

        String num7 = "Ivannn";
        String num8 = "Ivanovvvv";
        int salary3 = 30;
        Employee employee4 = new Employee(num1, num2, salary3, departmentId2);

// подготовка ожидаемого результата
        when(employeeService.getAllWorkers()).thenReturn(Arrays.asList(employee1, employee2,employee3,employee4));
        int expectedMaxSalary = salary + salary1;
//   начало теста
        int actualMaxSalary = departmentService.getTotalSalaryByDepartment(departmentId1);
        assertEquals(expectedMaxSalary,actualMaxSalary);
        assertNotEquals(departmentId1,departmentId2);
        verify(employeeService).getAllWorkers();
//        verifyNoMoreInteractions(expectedMaxSalary);
    }

    @Test
    void getMaxSalaryByDepartment() {
        // подготовка входных данных
        int departmentId1 = 1;

        String num1 = "Ivan";
        String num2 = "Ivanov";
        int salary = 21;
        Employee employee1 = new Employee(num1, num2, salary, departmentId1);

        String num3 = "Ivann";
        String num4 = "Ivanovv";
        int salary1 = 25;
        Employee employee2 = new Employee(num1, num2, salary1, departmentId1);

        int departmentId2 = 2;

        String num5 = "Ivannn";
        String num6 = "Ivanovvvv";
        int salary2 = 50;
        Employee employee3 = new Employee(num1, num2, salary2, departmentId2);

        String num7 = "Ivannn";
        String num8 = "Ivanovvvv";
        int salary3 = 30;
        Employee employee4 = new Employee(num1, num2, salary3, departmentId2);

// подготовка ожидаемого результата
        when(employeeService.getAllWorkers()).thenReturn(Arrays.asList(employee1, employee2,employee3,employee4));
        int expectedMaxSalary = Math.max(salary3, salary2);
//   начало теста
        int actualMaxSalary = departmentService.getMaxSalaryByDepartment(departmentId2).getSalary();
        assertEquals(expectedMaxSalary,actualMaxSalary);
        assertNotEquals(departmentId1,departmentId2);
        verify(employeeService).getAllWorkers();
//        verifyNoMoreInteractions(expectedMaxSalary);
    }

    @Test
    void getMaxSalaryByDepartment_notFoundException() {
        // подготовка входных данных
        int department = 1;
        // подготовка ожидаемого результата
        when(employeeService.getAllWorkers()).thenReturn(Collections.emptyList());
        String expectedErrorMessage = "Сотрудник не найден";
//        начало теста
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.getMaxSalaryByDepartment(department));
        assertEquals(expectedErrorMessage,exception.getMessage());

    }

    @Test
    void getMinSalaryByDepartment() {
        // подготовка входных данных
        int departmentId1 = 1;

        String num1 = "Ivan";
        String num2 = "Ivanov";
        int salary = 21;
        Employee employee1 = new Employee(num1, num2, salary, departmentId1);

        String num3 = "Ivann";
        String num4 = "Ivanovv";
        int salary1 = 25;
        Employee employee2 = new Employee(num1, num2, salary1, departmentId1);

        int departmentId2 = 2;

        String num5 = "Ivannn";
        String num6 = "Ivanovvvv";
        int salary2 = 50;
        Employee employee3 = new Employee(num1, num2, salary2, departmentId2);

        String num7 = "Ivannn";
        String num8 = "Ivanovvvv";
        int salary3 = 30;
        Employee employee4 = new Employee(num1, num2, salary3, departmentId2);

// подготовка ожидаемого результата
        when(employeeService.getAllWorkers()).thenReturn(Arrays.asList(employee1, employee2,employee3,employee4));
        int expectedMaxSalary = Math.min(salary, salary1);
//   начало теста
        int actualMaxSalary = departmentService.getMinSalaryByDepartment(departmentId1).getSalary();
        assertEquals(expectedMaxSalary,actualMaxSalary);
        assertNotEquals(departmentId1,departmentId2);
        verify(employeeService).getAllWorkers();
//        verifyNoMoreInteractions(expectedMaxSalary);
    }
    @Test
    void getMinSalaryByDepartment_notFoundException() {
        // подготовка входных данных
        int department = 1;
        // подготовка ожидаемого результата
        when(employeeService.getAllWorkers()).thenReturn(Collections.emptyList());
        String expectedErrorMessage = "Сотрудник не найден";
//        начало теста
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.getMinSalaryByDepartment(department));
        assertEquals(expectedErrorMessage,exception.getMessage());

    }

    @Test
    void getEmployeesGroupedByDepartment() {
        // подготовка входных данных
        int departmentId1 = 1;

        String num1 = "Ivan";
        String num2 = "Ivanov";
        int salary = 21;
        Employee employee1 = new Employee(num1, num2, salary, departmentId1);

        String num3 = "Ivann";
        String num4 = "Ivanovv";
        int salary1 = 25;
        Employee employee2 = new Employee(num1, num2, salary1, departmentId1);

        int departmentId2 = 2;

        String num5 = "Ivannn";
        String num6 = "Ivanovvvv";
        int salary2 = 50;
        Employee employee3 = new Employee(num1, num2, salary2, departmentId2);

        String num7 = "Ivannn";
        String num8 = "Ivanovvvv";
        int salary3 = 30;
        Employee employee4 = new Employee(num1, num2, salary3, departmentId2);

// подготовка ожидаемого результата
        when(employeeService.getAllWorkers()).thenReturn(Arrays.asList(employee1, employee2,employee3,employee4));
        Map<Integer, List<Employee>> expectedEmployeesGroupedByDepartment = new HashMap<>();
        expectedEmployeesGroupedByDepartment.put(departmentId1,  Arrays.asList(employee1, employee2));
        expectedEmployeesGroupedByDepartment.put(departmentId2,  Arrays.asList(employee3, employee4));

//   начало теста
        Map<Integer, List<Employee>> actualEmployeesGroupedByDepartment = departmentService.getEmployeesGroupedByDepartment();
        assertEquals(expectedEmployeesGroupedByDepartment,actualEmployeesGroupedByDepartment);
    }
}