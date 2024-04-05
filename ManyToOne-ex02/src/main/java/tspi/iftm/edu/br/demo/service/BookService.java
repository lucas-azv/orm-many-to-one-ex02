package tspi.iftm.edu.br.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tspi.iftm.edu.br.demo.domain.Book;
import tspi.iftm.edu.br.demo.repository.BookRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRep bookRep;

    public List<Book> getAllBooks() {
        Iterable<Book> booksIterable = bookRep.findAll();
        List<Book> books = new ArrayList<>();
        booksIterable.forEach(books::add);
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return bookRep.findById(id);
    }

    public Book createBook(Book book) {
        return bookRep.save(book);
    }

    public Book updateBook(Long id, Book book) {
        book.setId(id);
        return bookRep.save(book);
    }

    public void deleteBook(Long id) {
        bookRep.deleteById(id);
    }
}
