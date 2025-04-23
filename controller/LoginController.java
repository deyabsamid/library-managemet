package bd.edu.seu.samid_1.controller;

import bd.edu.seu.samid_1.model.Librarian;
import bd.edu.seu.samid_1.model.User;
import bd.edu.seu.samid_1.service.LibrarianService;
import bd.edu.seu.samid_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LibrarianService librarianService;
    private final UserService userService;

    public LoginController(LibrarianService librarianService, UserService userService) {
        this.librarianService = librarianService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
//        model.addAttribute("user",new User());
//        model.addAttribute("librarian",new Librarian());

        return "login";
    }

    @PostMapping("/login/submit")
    public String loginLibrarian(@RequestParam String email,@RequestParam String password){
////        Librarian checkLibrarian = librarianService.getByEmail(librarian.getEmail());
////        if(checkLibrarian != null && checkLibrarian.getPassword().equals(checkLibrarian.getPassword())){
////            return "redirect:/dashboard";
////        }
//
////        if(librarian.getEmail().equals("samid@gmail.com") && librarian.getPassword().equals("1234")) {
////            return "redirect:/dashboard";
////        }
////        return "redirect:/login?error=true";
//        User user = userService.authenticate(email,password);
//        Librarian librarian = librarianService.authenticate(email,password);
//        if(librarian != null){
//            return "redirect:/dashboard";
//        } else if (user != null) {
//            return "redirect:/library";
//        }
//        return "redirect:/login?error=true";
        Librarian librarian = librarianService.authenticate(email, password);
        if (librarian != null) {
            return "redirect:/dashboard";
        }

        User user = userService.authenticate(email, password);
        if (user != null) {
            return "redirect:/library";
        }

        return "redirect:/login?error=true";

    }
}
