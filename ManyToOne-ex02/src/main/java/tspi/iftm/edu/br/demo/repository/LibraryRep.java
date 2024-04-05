package tspi.iftm.edu.br.demo.repository;

import org.springframework.data.repository.CrudRepository;
import tspi.iftm.edu.br.demo.domain.Library;

public interface LibraryRep extends CrudRepository<Library, Long>{
    
}
