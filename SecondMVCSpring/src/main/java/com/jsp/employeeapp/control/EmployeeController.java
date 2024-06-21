package com.jsp.employeeapp.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import com.jsp.employeeapp.dao.EmployeeDao;
import com.jsp.employeeapp.dto.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	
	
	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("register");
		modelAndView.addObject("emp", new Employee());
		return modelAndView;
	}
	
	
	@PostMapping(value="/save")
	@ResponseBody
	public String saveEmployee(@ModelAttribute(name="emp") Employee employee) {
		employee = employeeDao.saveEmployee(employee);
		return "<h2>Employee saved with id:"+employee.getId()+"</h2>";
	}
	
	@RequestMapping("/open-view")
	public String openView(@RequestParam String view) {
		return view;
	}
	
	@RequestMapping(value="/open-update")
	public ModelAndView openUpdate(ModelAndView modelAndView) {
		modelAndView.setViewName("update");
		modelAndView.addObject("emp", new Employee());
		return modelAndView;
	}
	
	@PostMapping(value="/update")
	@ResponseBody
	public String updateEmployee(@ModelAttribute(name="emp") Employee employee) {
		employee = employeeDao.updateEmployee(employee);
		if(employee!=null) {
			return "<h2>Employee id:"+employee.getId()+" has been updated </h2>";
		}else {
			return "<h2>Cannot update the id you want </h2>";
		}
	}
	
	@GetMapping(value="/find-by-id")
	public ModelAndView findbyId(@RequestParam int id) {
		Employee employee = employeeDao.findById(id);
		ModelAndView modelAndView = new ModelAndView();
		if(employee!=null) {
			modelAndView.setViewName("display");
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}else {
			modelAndView.setViewName("error");
			modelAndView.addObject("message","Invalid Employee id");
			return modelAndView;
		}
	}
	
	
	@PostMapping(value="/verifybyphone")
	public ModelAndView verify(@RequestParam(name="phone") long phone, @RequestParam(name="password") String password) {
		
		Employee employee = employeeDao.verify(phone, password);
		ModelAndView mv = new ModelAndView();
		if(employee!=null) {
			mv.setViewName("display");
			mv.addObject("employee",employee);
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","invalid Phone number and password");
			return mv;
		}
	}
	
	@PostMapping(value="/verifybyemail")
	public ModelAndView verify(@RequestParam(name="email") String email, @RequestParam(name="password") String password) {
		Employee employee = employeeDao.verify(email, password);
		ModelAndView mv = new ModelAndView();
		if(employee!=null) {
			mv.setViewName("display");
			mv.addObject("employee",employee);
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","Invalid email or password");
			return mv;
		}
	}
	
	
	@PostMapping(value="/verifybyid")
	public ModelAndView verify(@RequestParam(name="id") int id, @RequestParam(name="password") String password) {
		Employee employee = employeeDao.verify(id, password);
		ModelAndView mv = new ModelAndView();
		if(employee!=null) {
			mv.setViewName("display");
			mv.addObject("employee",employee);
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","Invalid id or password");
			return mv;
		}
	}
	
	@RequestMapping(value="/delete-by-id")
	@ResponseBody
	public String dlt(@RequestParam int id) {
		Employee employee = employeeDao.deleteEmployee(id);
		if(employee!=null) {
			return "<h2>Employee with " +employee.getId() +" has been deleted </h2>";
		}else {
			return "<h2>Cannot perform deletion</h2>";
		}
	}
}
