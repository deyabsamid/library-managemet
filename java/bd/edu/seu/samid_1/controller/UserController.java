package bd.edu.seu.samid_1.controller;

import bd.edu.seu.samid_1.model.User;
import bd.edu.seu.samid_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("userToUpdate", new User());
        return "user-list";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/users/list";
    }
}
