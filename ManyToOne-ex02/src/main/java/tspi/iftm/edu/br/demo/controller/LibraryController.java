package tspi.iftm.edu.br.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tspi.iftm.edu.br.demo.domain.Library;
import tspi.iftm.edu.br.demo.service.LibraryService;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public ResponseEntity<List<Library>> getAllLibraries() {
        List<Library> libraries = libraryService.getAllLibraries();
        return new ResponseEntity<>(libraries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) {
        Library library = libraryService.getLibraryById(id)
                .orElseThrow(() -> new RuntimeException("Library not found with id: " + id));
        return new ResponseEntity<>(library, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library savedLibrary = libraryService.createLibrary(library);
        return new ResponseEntity<>(savedLibrary, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        Library updatedLibrary = libraryService.updateLibrary(id, library);
        return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
