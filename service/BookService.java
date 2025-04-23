package bd.edu.seu.samid_1.service;

import bd.edu.seu.samid_1.model.Book;
import bd.edu.seu.samid_1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book save (Book book){
        return bookRepository.save(book);
    }
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
