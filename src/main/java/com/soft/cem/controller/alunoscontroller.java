package com.soft.cem.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.soft.cem.util.GeneratePdfReport;


@Controller

public class alunoscontroller {

private AlunosJPA aluno;
private ArrayList<Alunos> users;	
	
@Autowired
public void setAlunosJPA (AlunosJPA aluno) {
	this.aluno = aluno;
}


@RequestMapping(value = "/alunos", method = RequestMethod.GET)
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



@RequestMapping(value = "/alunos", method = RequestMethod.POST)
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

@RequestMapping(value = "/alunos/fichaid/{matAlu}")
public ArrayList<Alunos> fichaid(@PathVariable Integer id, Model model) {
	users  = null;
	Alunos a = new Alunos();
	a = aluno.getOne(id);
	users.add(a);
    model.addAttribute("users", users );
    return users ;
}
/**

@RequestMapping(value = "/download", method = RequestMethod.GET)
public ArrayList<Alunos> download(Model model) {
	ArrayList<Alunos> users = null;
	users = (ArrayList<Alunos>) aluno.findAll();
    model.addAttribute("users", users);
    return users;
}
*/
 @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> alunosReport() throws IOException {

        
        List<Alunos> listaluno = (List<Alunos>) aluno.findAll(); 
        ByteArrayInputStream bis = GeneratePdfReport.alunosReport(listaluno);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=alunosreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }



	

}
