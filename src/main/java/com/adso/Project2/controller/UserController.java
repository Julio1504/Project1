package com.adso.Project2.controller;


import com.adso.Project2.model.Registro;
import com.adso.Project2.service.ServiceRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    private ServiceRegistro serviceRegistro;

    @GetMapping("/")
    public String index() {
        return "pages/index";
    }

    @GetMapping("/register/new")
    public String FormRegister(Model model) {
        model.addAttribute("registro", new Registro());
        return "pages/registro";
    }

    @PostMapping("/registro")
    public String CreateUser(@ModelAttribute Registro registro) {
        serviceRegistro.saveRegister(registro);
        return "pages/index";
    }

    @GetMapping("/registro")
    public String ListRegister(Model model) {
        model.addAttribute("result", serviceRegistro.getAllRegistro());
        return "redirect:/lista";
    }

    @RequestMapping("/lista")
    public String result(Model modelo) {
        modelo.addAttribute("result", this.serviceRegistro.getAllRegistro());
        return "pages/lista";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/lista/{id}")
    public String deleteRegister(@PathVariable Long id) {
        serviceRegistro.deleteRegister(id);
        return "redirect:/lista";
}

}