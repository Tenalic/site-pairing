package com.tenalic.site.testBdd;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeControler {

	@Autowired
	private EmployeeRepo ec;

	@PostMapping("/employee")
	public String employeePost(@RequestParam(value = "idEmployee", required = true) String idEmployee, Model model,
			HttpSession session) {

		Employee employee = ec.findById(idEmployee).orElse(new Employee());

		model.addAttribute("employee", employee);

		return "connection";
	}

}
