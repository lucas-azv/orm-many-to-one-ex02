package tspi.iftm.edu.br.demo.repository;

import org.springframework.data.repository.CrudRepository;
import tspi.iftm.edu.br.demo.domain.Book;

public interface BookRep extends CrudRepository<Book, Long>{
    
}
