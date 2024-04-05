package tspi.iftm.edu.br.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Library {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String name;
}
