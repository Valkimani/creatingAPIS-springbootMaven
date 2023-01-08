package com.example.springbootMaven.controller;

import com.example.springbootMaven.entity.Employee;
import com.example.springbootMaven.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
//Mark the class as a controller above. This class needs to be able to handle this request but the class below needs to know
public class EmployeeController {
//  Step:2  Create a list of all employees with the method below, then return a list of employees
//    public List<Employee> employeeList;
//    Step: 1 The method below finds a list of all the employees and then
//    returns a list of all employees
//    To trigger the findAllEmployees method, we need to use the mapping annotation below

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/employees")
//    Were parsing a response to the body

    public List<Employee> findAllEmployees() {
//        Initialize the employeeList in here
        // *** Move the list of employees to the service class
//         List<Employee> employeeList = Arrays.asList(
//                new Employee( 1, "John Smith", "New York"),
//                new Employee( 2, "Jane Doe", "Boston"),
//                new Employee( 3, "Pete Black", "San Jose")
//        );
    return employeeService.getAllEmployees();
    }
    @RequestMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id){
       return employeeService.getAnEmployee(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }
}
