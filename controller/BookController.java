package bd.edu.seu.samid_1.controller;

import bd.edu.seu.samid_1.model.Book;
import bd.edu.seu.samid_1.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/list")
    public String bookList(Model model){
        model.addAttribute("books",bookService.findAll());
        model.addAttribute("bookToUpdate", new Book());
        return "bookList";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteById(id);
        return "redirect:/books/list";
    }
//    @PostMapping("/update")
//    public String updateBook(@ModelAttribute Book book) {
//        bookService.save(book);
//        return "redirect:/books/list";
//    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book updatedBook) {
        // First find the existing book by ID or ISBN
        Book existingBook = bookService.findByIsbn(updatedBook.getIsbn())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Update only the fields that should change
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setCategory(updatedBook.getCategory());
        existingBook.setCopies(updatedBook.getCopies());

        // Save the updated book
        bookService.save(existingBook);
        return "redirect:/books/list";
    }
}
