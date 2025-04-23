package bd.edu.seu.samid_1.controller;

import bd.edu.seu.samid_1.model.Librarian;
import bd.edu.seu.samid_1.service.LibrarianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibrarianRegistrationController {
    private final LibrarianService librarianService;

    public LibrarianRegistrationController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping("/")
    public String RegistrationForm(Model model){
        model.addAttribute("librarian",new Librarian());
        return "register";
    }
    @PostMapping("/submit-librarian")
    public String Submit(@ModelAttribute Librarian librarian){
        System.out.println(librarian.getEmail()+" "+librarian.getName());
       librarianService.create(librarian);
        return "register";
    }
}
