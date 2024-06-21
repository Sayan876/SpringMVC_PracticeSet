package com.jspmvc.control;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jspmvc.dao.EmployeeDao;
import com.jspmvc.dto.Employee;

@Controller
public class EmployeeControl {
	@Autowired
  private EmployeeDao eDao;
  
	
	@RequestMapping("/open-view")
	public String openView(@RequestParam String view) {
		return view;
	}
	
	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView mv) {
		mv.setViewName("register");
		mv.addObject("emp", new Employee());
		return mv;
	}
	
	
	@PostMapping("/save")
	@ResponseBody
	public String saveEmployee(@ModelAttribute(name="emp") Employee e) {
		e = eDao.saveEmployee(e);
		return "<h2>Employee saved with "+e.getId()+"</h2>";
	}
	
	
	@RequestMapping("/open-update")
	public ModelAndView openUpdate(ModelAndView mv) {
		mv.setViewName("update");
		mv.addObject("emp", new Employee());
		return mv;
	}
	
	
	@PostMapping("/update")
	@ResponseBody
	public String updateEmployee(@ModelAttribute(name="emp") Employee e){
		e = eDao.updateEmployee(e);
		return "<h2>Employee Updated with "+e.getId()+"</h2>";
	}
	
	
	@GetMapping("/fbyid")
	public ModelAndView findbid(@RequestParam int id) {
		Employee ed = eDao.findById(id);
		ModelAndView mv = new ModelAndView();
		if(ed!=null) {
			mv.setViewName("display");
			mv.addObject("employee", ed);
			return mv;
		}
		else {
			mv.setViewName("error");
			mv.addObject("message","Wrong id");
			return mv;
		}
	}
	
	
	@RequestMapping("/delete-by-id")
	@ResponseBody
	public String delbyid(@RequestParam int id) {
		Employee ed = eDao.deleemp(id);
		ModelAndView mv = new ModelAndView();
		if(ed!=null) {
			return "<h2>employee Deleted</h2>";
		}else {
			return "<h2>Cannot delete</h2>";
		}
	}
	
	
	@PostMapping("/verification")
	public ModelAndView verify(@RequestParam(name="id") int id, @RequestParam(name="name") String name) {
		Employee ed = eDao.verify(id, name);
		ModelAndView mv = new ModelAndView();
		if(ed!=null) {
			mv.setViewName("display");
			mv.addObject("employee",ed);
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","Wrong id and name");
			return mv;
		}
	}
}
