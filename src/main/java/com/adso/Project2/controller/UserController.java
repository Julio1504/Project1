//package com.adso.Project2.controller;
//
//import com.adso.Project2.model.Registro;
//import com.adso.Project2.service.ServiceRegistro;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//    @Autowired
//    private ServiceRegistro serviceRegistro;
//
//    @GetMapping("/register/new")
//    public String formRegister(Model model){
//        model.addAttribute("registro", new Registro());
//        return "pages/registro";
//    }
//
//    @PostMapping("/registro")
//    public String createRegister(@ModelAttribute Registro registro, Model model){
//        serviceRegistro.saveRegister(registro);
//        model.addAttribute("result", serviceRegistro.getAllRegistro());
//        return "redirect:/registro";
//    }
//    @GetMapping("/registro")
//    public String listRegister(Model model){
//        model.addAttribute("result", serviceRegistro.getAllRegistro());
//        return "page/index";
//    }
//    @GetMapping("/")
//    public String Prueba(){
//        return "dataSave";
//    }
//}

package com.adso.Project2.controller;


import com.adso.Project2.model.Registro;
import com.adso.Project2.service.ServiceRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller //Para definir la clase como controlador
public class UserController {
    @Autowired //Instanciar una clase dentro de una clase
    private ServiceRegistro serviceRegistro;

    @GetMapping("/register/new") //
    public String FormRegister(Model model){
        model.addAttribute("registro", new Registro());
        return "pages/registro";
    }

    @PostMapping("/registro")
    public String CreateUser(@ModelAttribute Registro registro){
        serviceRegistro.saveRegister(registro);
        return "pages/index";
    }

    @GetMapping("/registro")
    public String ListRegister(Model model){
        model.addAttribute("result", serviceRegistro.getAllRegistro());
        return "fragments/dataSave";
    }
    /* @GetMapping("/")
    public String index(){
        return "pages/index";
    }
    @GetMapping("/users")
        public String users(){
        return "pages/users";
    }

    @GetMapping("/registro")
        public String registro(){
        return "pages/register";
    }

    @GetMapping("/login")
    public String login(){
        return "pages/login";
*/



}

