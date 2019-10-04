package kosal.springframework.spring5webapp.repositories;

import kosal.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepisitory extends CrudRepository<Author, Long>  {



}
