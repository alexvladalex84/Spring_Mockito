package com.example.spring_makito_employeebook.Instance.Service;

import com.example.spring_makito_employeebook.Exception.ArrayIsFullException;
import com.example.spring_makito_employeebook.Exception.InvalidNameException;
import com.example.spring_makito_employeebook.Exception.NumberDepartmentException;
import com.example.spring_makito_employeebook.Instance.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceImplTest {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    void addWorkers_firstNameNotInUpperCase() {
//        входящие данные
        String firstName = "ivan";
        String lastName = "Ivanov";
//        ожидаемый результат
        String expectedMassage = "Имя не с заглавной буквы";
//        начало теста
        Exception exception = Assertions.assertThrows(InvalidNameException.class, () -> employeeService.addWorkers(firstName,
                lastName, 1, 1));
        Assertions.assertEquals(expectedMassage, exception.getMessage());

    }

    @Test
    void addWorkers_lastNameNotInUpperCase() {
//        входящие данные
        String firstName = "Ivan";
        String lastName = "ivanov";
//        ожидаемый результат
        String expectedMassage = "Фамилия не с заглавной буквы";
//        начало теста
        Exception exception = Assertions.assertThrows(InvalidNameException.class, () -> employeeService.addWorkers(firstName,
                lastName, 1, 1));
        Assertions.assertEquals(expectedMassage, exception.getMessage());

    }

    @Test
    void addWorkers_tryingToAddAnExistingEmployee() {
        //        входящие данные
        String firstName = "Ivan";
        String lastName = "Ivanov";
        //        ожидаемый результат
        String expected = "Сотрудник " + new Employee(firstName, lastName, 1, 1) +
                " добавлен!";
        String expectedMassage = "Попытка добавить уже существующего сотрудника!";
        //        начало теста
        String addedEmployee = employeeService.addWorkers(firstName, lastName, 1, 1);
        assertEquals(expected, addedEmployee);
        Exception exception = Assertions.assertThrows(ArrayIsFullException.class, () -> employeeService.addWorkers(firstName,
                lastName, 1, 1));
        Assertions.assertEquals(expectedMassage, exception.getMessage());
    }

    @Test
    void addWorkers_testForAddWorkers() {
        //      входящие данные
        String firstName = "Ivan";
        String lastName = "Ivanov";
//        ожидаемый результат
        String expected = "Сотрудник " + new Employee(firstName, lastName, 1, 1) +
                " добавлен!";
//        начало теста
        assertEquals(expected, employeeService.addWorkers(firstName, lastName, 1, 1));

    }

    @Test
    void findWorker_employeeDoesNotExist() {
//        входящие данные
        fullEmployees();
        String firstName = "Iva";
        String lastName = "Ivano";
//        ожидаемый результат
        String expectedMassage = "Сотрудника с таким именем или фамилией не существует!";
//        начало теста
        Exception exception = Assertions.assertThrows(ArrayIsFullException.class, () ->
                employeeService.findWorker(firstName,
                        lastName, 1, 1));
        Assertions.assertEquals(expectedMassage, exception.getMessage());

        cleanEmployees();
    }

    @Test
    void findWorker_find() {
        //        входящие данные
        fullEmployees();
        String firstName = "Ivan";
        String lastName = "Ivanov";
        //        ожидаемый результат
        String expected = "Сотрудник " + new Employee(firstName, lastName, 1, 1) + " найден";

        //        начало теста
        String find = employeeService.findWorker(firstName, lastName, 1, 1);
        Assertions.assertEquals(expected, find);

        cleanEmployees();

    }

    @Test
    void removeTheWorker_employeeDoesNotExist() {
        //        входящие данные
        fullEmployees();
        String firstName1 = "Iva";
        String lastName2 = "Ivano";
        //        ожидаемый результат

        String expectedMassage = "Сотрудника с таким именем или фамилией не существует!";
        //        начало теста


        Exception exception = Assertions.assertThrows(ArrayIsFullException.class, () ->
                employeeService.removeTheWorker(firstName1,
                        lastName2, 1, 1));
        Assertions.assertEquals(expectedMassage, exception.getMessage());

        cleanEmployees();
    }

    @Test
    void removeTheWorker_remove() {
        //        входящие данные
        fullEmployees();
        String firstName = "Ivan";
        String lastName = "Ivanov";
        //        ожидаемый результат
        String expected = "Сотрудник " + new Employee(firstName, lastName, 1, 1) + " удален!";

        //        начало теста

        String remove = employeeService.removeTheWorker(firstName, lastName, 1, 1);
        String add = employeeService.addWorkers(firstName, lastName, 1, 1);
        Assertions.assertEquals(expected, remove);

        cleanEmployees();

    }

    @Test
    void getAllWorkers() {
//        входные данные
        fullEmployees();

//        ожидаемый результат
        String expected = employeeService.getAllWorkers().toString();

//        начало теста
        String all = employeeService.getAllWorkers().toString();
        Assertions.assertEquals(expected, all);

        cleanEmployees();
    }

    @Test
    void minMaxNumberOfDepartments_min() {
        //        входящие данные
        int num1 = 0;
        //        ожидаемый результат
        String expectedMassage = "Такого номера департамента не существует!";
        //        начало теста

        Exception exception = Assertions.assertThrows(NumberDepartmentException.class, () ->
                employeeService.minMaxNumberOfDepartments(num1));
        Assertions.assertEquals(expectedMassage, exception.getMessage());
    }

    @Test
    void minMaxNumberOfDepartments_max() {
        //        входящие данные
        int num1 = 6;
        //        ожидаемый результат
        String expectedMassage = "Такого номера департамента не существует!";
        //        начало теста

        Exception exception = Assertions.assertThrows(NumberDepartmentException.class, () ->
                employeeService.minMaxNumberOfDepartments(num1));
        Assertions.assertEquals(expectedMassage, exception.getMessage());
    }

    @Test
    void minMaxNumberOfDepartments_actual() {
        //        входящие данные
        int num1 = (int) (Math.random() * (1 + 4)) + 1;
        //        ожидаемый результат
        int expected = num1;
        //        начало теста

        int exception = employeeService.minMaxNumberOfDepartments(num1);
        Assertions.assertEquals(expected, exception);
    }


    private void fullEmployees() {
        employeeService.addWorkers("Ivan", "Ivanov", 1, 1);
        employeeService.addWorkers("Ivann", "Ivanov", 1, 1);
        employeeService.addWorkers("Ivannn", "Ivanov", 1, 1);


    }

    private void cleanEmployees() {
        employeeService.removeTheWorker("Ivan", "Ivanov", 1, 1);
        employeeService.removeTheWorker("Ivann", "Ivanov", 1, 1);
        employeeService.removeTheWorker("Ivannn", "Ivanov", 1, 1);

    }

}