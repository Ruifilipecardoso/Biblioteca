package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Bibliotecario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        Bibliotecario bibliotecario = (Bibliotecario) session.getAttribute("bibliotecarioLogado");

        if (bibliotecario == null) {
            return "redirect:/login";
        }

        model.addAttribute("bibliotecario", bibliotecario);

        return "index";
    }
}
