package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;

@Controller
public class PersonController {
	@Autowired
  private PersonDao pdao;
	
	
	
	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView mv) {
		mv.setViewName("register");
		mv.addObject("pers", new Person());
		return mv;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public String savePerson(@ModelAttribute(name="pers") Person person) {
		person = pdao.savePerson(person);
		return "<h2> Person saved with id" + person.getId()+"</h2>";
	}
	
	@RequestMapping("/open-view")
	public String openView(String view) {
		return view;
	}
	
	@RequestMapping("/open-update")
	public ModelAndView openUpdate(ModelAndView mv) {
		mv.setViewName("update");
		mv.addObject("pers", new Person());
		return mv;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public String updatePeron(@ModelAttribute(name="pers") Person person) {
		person = pdao.updatePerson(person);
		return "<h2>Person update under the id "+person.getId()+"</h2>";
	}
	
	
	@PostMapping("/find-by-id")
	public ModelAndView FindbyId(@RequestParam(name="id") int id) {
		Person person = pdao.findbyid(id);
		ModelAndView mv = new ModelAndView();
		if(person!=null) {
			mv.setViewName("display");
			mv.addObject("person",person);
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","Invalid id");
			return mv;
		}
	}
	
	@PostMapping("/delete-by-id")
	public ModelAndView delper(@RequestParam(name="id") int id) {
		Person person = pdao.deleper(id);
		ModelAndView mv = new ModelAndView();
		if(person!=null) {
			mv.setViewName("cnfpage");
			mv.addObject("deact","Account deleted");
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","Invalid id");
			return mv;
		}
	}
}

