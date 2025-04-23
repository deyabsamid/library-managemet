package bd.edu.seu.samid_1.controller;

import bd.edu.seu.samid_1.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddBookController {
    @GetMapping("/addBook")
    public String Book(Model model){
        model.addAttribute("book", new Book());
        return "addBook";
    }
}
