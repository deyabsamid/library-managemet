package bd.edu.seu.samid_1.repository;

import bd.edu.seu.samid_1.model.Librarian;
import bd.edu.seu.samid_1.service.LibrarianService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
//    Optional<Librarian> findByEmail(String email);
    Librarian findByEmail(String email);
}
