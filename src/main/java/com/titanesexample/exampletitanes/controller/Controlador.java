package com.titanesexample.exampletitanes.controller;

import com.titanesexample.exampletitanes.interfaceService.IempresaService;
import com.titanesexample.exampletitanes.modelo.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IempresaService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Empresa>empresas=service.listar();
        model.addAttribute("empresas", empresas);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "form";
    }
    @PostMapping("/save")
    public String save(@Validated Empresa e, Model model){
        service.save(e);
        return "redirect:/listar";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Empresa>empresa=service.listarId(id);
        model.addAttribute("empresa", empresa);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }



}
