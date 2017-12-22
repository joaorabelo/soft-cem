package com.soft.cem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soft.cem.model.Alunos;
import com.soft.cem.model.Enderecos;
import com.soft.cem.model.Responsaveis;
import com.soft.cem.repository.AlunosJPA;


@Controller
@RequestMapping("/alunos")
public class alunoscontroller {
	
@Autowired
private AlunosJPA aluno;





@GetMapping
public ModelAndView listar() {
	// deveria ter um metodo para criar esses objetos, mas fiz no listar mesmo
	ModelAndView modelAndView = new ModelAndView("ListaAlunos");
	modelAndView.addObject("alunos", aluno.findAll());
	modelAndView.addObject("aluno", new Alunos());
	modelAndView.addObject("end", new Enderecos());
	modelAndView.addObject("resp", new Responsaveis());
	modelAndView.addObject("endresp", new Enderecos());
	return modelAndView;
}


@PostMapping
public String salvar(Alunos aluno, Enderecos end, Responsaveis resp, Enderecos endresp ) {
	aluno.setIdEnd(end);
	aluno.setIdResp(resp);
	aluno.getIdResp().setIdEnd(endresp);
	this.aluno.save(aluno);
	
	return "redirect:/alunos";
}

@RequestMapping("/editaluno/{aluno}")
public ModelAndView editar(@PathVariable Alunos aluno) {
	
	ModelAndView mv = new ModelAndView("editaraluno");
	
	mv.addObject(aluno);
	
	return mv;
}

@RequestMapping("/alteraluno")
public String editaralterar(@Validated Alunos aluno) {
	
	Alunos alunonovo = aluno;

	this.aluno.delete(aluno.getMatAlu());

	this.aluno.save(alunonovo);

	return "redirect:/alunos";
}

@RequestMapping("/excluialuno/{matAlu}")
public String excluir(@PathVariable Integer matAlu) {
	this.aluno.delete(matAlu);
	return "redirect:/alunos";
}



	

}
