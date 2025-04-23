package bd.edu.seu.samid_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @GetMapping("/library")
    public String userLibraryPage() {
        return "library"; // this should correspond to a file named library.html under templates/
    }
}

