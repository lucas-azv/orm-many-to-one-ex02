package tspi.iftm.edu.br.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tspi.iftm.edu.br.demo.domain.Library;
import tspi.iftm.edu.br.demo.repository.LibraryRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRep libraryRep;

    public List<Library> getAllLibraries() {
        Iterable<Library> librariesIterable = libraryRep.findAll();
        List<Library> libraries = new ArrayList<>();
        librariesIterable.forEach(libraries::add);
        return libraries;
    }

    public Optional<Library> getLibraryById(Long id) {
        return libraryRep.findById(id);
    }

    public Library createLibrary(Library library) {
        return libraryRep.save(library);
    }

    public Library updateLibrary(Long id, Library library) {
        library.setId(id);
        return libraryRep.save(library);
    }

    public void deleteLibrary(Long id) {
        libraryRep.deleteById(id);
    }
}
