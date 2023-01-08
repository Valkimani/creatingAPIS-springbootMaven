package com.example.springbootMaven.service;

import com.example.springbootMaven.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EmployeeService {

    //    Move the logic of creating a list of employees to
   //    the service class. Moved the list from the controller to the service. That way the service
  //    class is creating the employee list and returning the employee list
    List<Employee> employeeList = new ArrayList<>(Arrays.asList
            (
            new Employee(1, "John Smith", "New York"),
            new Employee(2, "Jane Doe", "Boston"),
            new Employee(3, "Pete Black", "San Jose")
    ));

    public List<Employee> getAllEmployees() {
return employeeList;
    }

    public Employee getAnEmployee(int id){
//Defining a lambda expression. Filter the list using filter (). If the id is equal to
//        employee.get id then get the first employee and return ot
        return employeeList.stream().filter(employee -> (
                employee.getEmployeeId() == id)).findFirst().get();
    }
//    Create a method which created an employee

    public void createEmployee(Employee employee) {
        employeeList.add(employee);
    }
}

