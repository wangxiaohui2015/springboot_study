package com.my.study.restful.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.my.study.restful.entity.Employee;
import com.my.study.restful.mockdb.EmployeeDB;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE})
public class EmployeeController {

    // Query all employees
    @RequestMapping(value = "/employee/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employees = EmployeeDB.findAllEmployees();
        if (employees.isEmpty()) {
            // You may decide to return HttpStatus.NOT_FOUND
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    // Query one employee by ID
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") int id) {
        Employee employee = EmployeeDB.findEmployee(id);
        if (null == employee) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // Add one employee
    @RequestMapping(value = "/employee/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee,
                    UriComponentsBuilder ucBuilder) {
        if (null != EmployeeDB.findEmployee(employee.getId())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        EmployeeDB.addEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        // This is to send client a URL of how to get added employee
        headers.setLocation(
                        ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Update employee
    @RequestMapping(value = "/employee/", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee currentEmployee = EmployeeDB.findEmployee(employee.getId());
        if (null == currentEmployee) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        EmployeeDB.updateEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // Delete employee by ID
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        Employee currentEmployee = EmployeeDB.findEmployee(id);
        if (null == currentEmployee) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        EmployeeDB.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // Delete all employees
    @RequestMapping(value = "/employee/", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAllEmployees() {
        EmployeeDB.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
