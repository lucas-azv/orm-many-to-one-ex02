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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// criando uma biblioteca
		Library library = new Library();
		library.setName("IFTM");

		// Criando alguns livros
		Book book1 = new Book();
		book1.setName("Java");
		book1.setLibrary(library);

		Book book2 = new Book();
		book2.setName("Spring");
		book2.setLibrary(library);

		// Salvando a biblioteca e os livros
		libraryRepository.save(library);
		bookRepository.save(book1);
		// bookRepository.save(book2);

		// Buscando todos os livros
		System.out.println("\n------------------------------------------------\nLivros do BD:");
		Iterable<Book> books = bookRepository.findAll();
		books.forEach(book -> {
			System.out.println(book.getName() + " da biblioteca " + book.getLibrary().getName());
		});

		// Buscando todos os livros
		System.out.println("\n------------------------------------------------\nLivros da RAM:");
		System.out.println(book1.getName() + " da biblioteca " + book1.getLibrary().getName());
		System.out.println(book2.getName() + " da biblioteca " + book2.getLibrary().getName());

		System.out.println("\n------------------------------------------------\nfim");
	}

}
