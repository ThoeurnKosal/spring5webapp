package kosal.springframework.spring5webapp.bootstrap;

import kosal.springframework.spring5webapp.model.Author;
import kosal.springframework.spring5webapp.model.Book;
import kosal.springframework.spring5webapp.model.Publisher;
import kosal.springframework.spring5webapp.repositories.AuthorRepisitory;
import kosal.springframework.spring5webapp.repositories.BookRepository;
import kosal.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepisitory authorRepisitory;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepisitory authorRepisitory, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepisitory = authorRepisitory;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

   private void initData(){

       Publisher publisher = new Publisher();
       publisher.setName("foo");
       publisherRepository.save(publisher);

       //Eric
       Author eric = new Author("Eric","Evans");
       Book ddd = new Book("Domain Driven Design", "1234", publisher);
       eric.getBooks().add(ddd);
       ddd.getAuthors().add(eric);

       authorRepisitory.save(eric);
       bookRepository.save(ddd);

       //Road
       Author rod = new Author("Rod","Johnson");
       Book noEJB = new Book("J2EE Development without EJB","23124",publisher);
       rod.getBooks().add(noEJB);
       authorRepisitory.save(rod);
       bookRepository.save(noEJB);
   }


}
