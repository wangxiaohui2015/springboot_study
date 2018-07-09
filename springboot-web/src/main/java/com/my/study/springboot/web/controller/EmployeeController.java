package com.my.study.springboot.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.study.springboot.web.entity.Employee;
import com.my.study.springboot.web.mockdb.EmployeeDB;

@Controller
public class EmployeeController {
	@RequestMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = EmployeeDB.findAllEmployees();
		model.addAttribute("employees", employees);
		return "employee/list_employees";
	}
}
