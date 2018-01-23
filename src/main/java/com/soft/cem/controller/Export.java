package com.soft.cem.controller;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.cem.model.Alunos;
import com.soft.cem.repository.AlunosJPA;



public class Export {

    @Autowired
    private AlunosJPA aluno;

    /**
     * Handle request to download an Excel document
     */
    /**
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ArrayList<Alunos> download(Model model) {
    	ArrayList<Alunos> users = null;
    	users = (ArrayList<Alunos>) aluno.findAll();
        model.addAttribute("users", users);
        return users;
    }

*/
}
