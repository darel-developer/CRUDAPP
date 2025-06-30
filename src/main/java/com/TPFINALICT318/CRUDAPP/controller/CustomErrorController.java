package com.TPFINALICT318.CRUDAPP.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Vous pouvez ajouter une logique pour gérer différents codes d'erreur si nécessaire
        return "error";
    }
}