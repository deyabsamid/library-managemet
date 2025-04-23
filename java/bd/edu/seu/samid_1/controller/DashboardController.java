package bd.edu.seu.samid_1.controller;

import bd.edu.seu.samid_1.model.Book;
import bd.edu.seu.samid_1.model.Librarian;
import bd.edu.seu.samid_1.model.User;
import bd.edu.seu.samid_1.service.BookService;
import bd.edu.seu.samid_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {
    private final UserService userService;
    private final BookService bookService;


    public DashboardController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }



    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("book",new Book());
        return "dashboard";
    }

    @PostMapping("/register-user")
    public String RegisterUser(@ModelAttribute("user") User user,Model model){
        userService.create(user);
        model.addAttribute("user", new User());
        model.addAttribute("book", new Book());

        return "/dashboard";
    }

    @PostMapping("/add-book")
    public String AddBook(@ModelAttribute("book") Book book,Model model){
        bookService.save(book);
        model.addAttribute("book", new Book());
        model.addAttribute("user", new User());
        return "/dashboard";
    }
}
