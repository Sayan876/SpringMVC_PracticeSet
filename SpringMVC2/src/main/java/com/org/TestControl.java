package com.org;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControl {
	@RequestMapping (value ="/subzero")
	@ResponseBody
    public String test() {
    	return "<h1>Configuration is ok</h1>";
    }
	
	//tight coupling
//	@RequestMapping(value = "/home")
//	public String world() {
//		return "/WEB-INF/views/home.jsp";
//	}
	@RequestMapping(value = "/open-view")
	public String openHome(@RequestParam(name="view") String view) {
		return view;
	}
	
	@RequestMapping(value ="/sum")
	public String findsum(@RequestParam(name="n1") int n1,@RequestParam(name="n2") int n2, Model model) {
		String result = n2 + "+" + n2 +"="+(n2+n1);
		model.addAttribute("res",result);
		return "print";
	}
	
	@RequestMapping(value="/open-register")
	public ModelAndView openRegister() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		mv.addObject("user",new UserRequest());
		return mv;
	}
	
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@ModelAttribute(name="user") UserRequest request) {
		return request.toString();
	}
}
