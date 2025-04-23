package bd.edu.seu.samid_1.repository;

import bd.edu.seu.samid_1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByIsbn(String isbn);
}
