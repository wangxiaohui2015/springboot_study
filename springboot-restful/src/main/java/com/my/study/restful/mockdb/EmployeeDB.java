package com.my.study.restful.mockdb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.my.study.restful.entity.Employee;

/**
 * Employee mock DB
 */
public class EmployeeDB {
    private static final List<Employee> EMPLOYEES = new ArrayList<>();
    static {
        for (int i = 0; i < 3; i++) {
            EMPLOYEES.add(new Employee(i, "user" + i, 20 + i, "desc " + i + "."));
        }
    }

    public static Employee findEmployee(int id) {
        for (Employee e : EMPLOYEES) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static List<Employee> findAllEmployees() {
        return EMPLOYEES;
    }

    public static synchronized void addEmployee(Employee employee) {
        EMPLOYEES.add(employee);
    }

    public static void updateEmployee(Employee employee) {
        for (Employee e : EMPLOYEES) {
            if (e.getId() == employee.getId()) {
                e.setName(employee.getName());
                e.setAge(employee.getAge());
                e.setDesc(employee.getDesc());
                return;
            }
        }
    }

    public static void deleteEmployee(int id) {
        Iterator<Employee> it = EMPLOYEES.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getId() == id) {
                it.remove();
                return;
            }
        }
    }

    public static void deleteAll() {
        EMPLOYEES.clear();
    }
}
