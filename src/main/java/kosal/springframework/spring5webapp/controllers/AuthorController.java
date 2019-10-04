package kosal.springframework.spring5webapp.controllers;

import kosal.springframework.spring5webapp.repositories.AuthorRepisitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepisitory authorRepisitory;

    public AuthorController(AuthorRepisitory authorRepisitory) {
        this.authorRepisitory = authorRepisitory;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepisitory.findAll());
        return "authors";
    }

}
