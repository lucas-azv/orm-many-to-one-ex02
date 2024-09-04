import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.biblioteca.domain.Book;
import br.edu.iftm.biblioteca.domain.Library;
import br.edu.iftm.biblioteca.repository.BookRepository;
import br.edu.iftm.biblioteca.repository.LibraryRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    // Variáveis de instância para book1 e book2
    private Book book1;
    private Book book2;

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // criando uma biblioteca
        Library library = new Library();
        library.setName("IFTM");

        // Criando alguns livros
        book1 = new Book();
        book1.setName("Java");
        book1.setLibrary(library);

        book2 = new Book();
        book2.setName("Spring");
        book2.setLibrary(library);

        // Salvando a biblioteca e os livros
        libraryRepository.save(library);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

    // Buscando todos os livros
    private static final String SEPARATOR = "\n------------------------------------------------\n";
    private static final String FROM_LIBRARY = " da biblioteca ";
    private static final String BD_BOOKS_HEADER = "Livros do BD:";
    private static final String RAM_BOOKS_HEADER = "Livros da RAM:";
    private static final String END_MESSAGE = "fim";

    public void printBooks() {
        // Printing books from the database
        System.out.println(SEPARATOR + BD_BOOKS_HEADER);
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(book -> {
            System.out.println(book.getName() + FROM_LIBRARY + book.getLibrary().getName());
        });

        // Printing books from RAM
        System.out.println(SEPARATOR + RAM_BOOKS_HEADER);
        System.out.println(book1.getName() + FROM_LIBRARY + book1.getLibrary().getName());
        System.out.println(book2.getName() + FROM_LIBRARY + book2.getLibrary().getName());

        System.out.println(SEPARATOR + END_MESSAGE);
    }

}
