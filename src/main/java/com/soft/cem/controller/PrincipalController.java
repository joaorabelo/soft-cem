package com.soft.cem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class PrincipalController {
	
	@RequestMapping("/principal")

	public ModelAndView mostrar() {

		

		ModelAndView mv = new ModelAndView("header");

		

		return mv;

	}

}
