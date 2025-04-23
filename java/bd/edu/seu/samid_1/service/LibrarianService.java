package bd.edu.seu.samid_1.service;

import bd.edu.seu.samid_1.model.Librarian;
import bd.edu.seu.samid_1.repository.LibrarianRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibrarianService {
    private final LibrarianRepository librarianRepository;

    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }
    public Librarian create(Librarian librarian){
        return librarianRepository.save(librarian);
    }
//    public Librarian getByEmail(String email){
//        Optional<Librarian> optional = librarianRepository.findByEmail(email);
//        if(optional.isPresent()){
//            return optional.get();
//        }
//        return null;
//    }
    public Librarian authenticate(String email, String password){
        Librarian librarian = librarianRepository.findByEmail(email);
        if(librarian != null && librarian.getPassword().equals(password)){
            return librarian;
        }
        return null;
    }

}
