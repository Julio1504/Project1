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

    //PAGINA INDEX

    @GetMapping("/")
    public String index() {
        return "pages/index";
    }

    //FORMULARIO DEL REGISTRO

    @GetMapping("/register/new")
    public String FormRegister(Model model) {
        model.addAttribute("registro", new Registro()); //Crea un nuevo modelo de registro vacio
        return "pages/registro";
    }

    @PostMapping("/registro")
    public String CreateUser(@ModelAttribute Registro registro) { //@ModelAttribute vincula datos de modelo a controladores
        serviceRegistro.saveRegister(registro); //Trae el modelo registro vacio y se guardan los datos ingresados
        return "redirect:/lista";
    }


    //MOSTRAR DATOS
    @RequestMapping("/lista")
    public String result(Model modelo) {
        modelo.addAttribute("result", this.serviceRegistro.getAllRegistro());
        return "pages/lista";
    }

    //ELIMINAR

    @GetMapping("/lista/{id}")
    public String deleteRegister(@PathVariable Long id) {
        serviceRegistro.deleteRegister(id);
        return "redirect:/lista";
}

    //UPDATE - TRAER DATOS

    @GetMapping("/registro/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) { //@PathVariable es para traer los datos de la URL --- Model model es es un modelo en general
        Registro registro = serviceRegistro.getRegisterById(id);
        model.addAttribute("registro", registro); //Crea una variable y guarda los datos de una variable ya creada de registro.
        return "pages/editRegistro"; // Nombre de la vista del formulario de edición
    }

    //UPDATE

    @PostMapping("/registro/update/{id}")
    public String updateRegister(@PathVariable("id") Long id, @ModelAttribute Registro registro) { //ModelAttribute es un modelo especifico
        serviceRegistro.updateRegister(registro);
        return "redirect:/lista"; // Redirige a la lista de registros después de actualizar
    }

    //REDIRECCION AL LOGIN

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }
}
