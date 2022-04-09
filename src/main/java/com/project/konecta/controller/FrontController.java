package com.project.konecta.controller;

import com.project.konecta.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FrontController {
    @Autowired InventarioService service;
    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("productos",service.findAll());
        model.addAttribute("ventas",service.findAllVentas());
        return "index";
    }
}
