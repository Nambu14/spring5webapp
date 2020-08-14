package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher omega = new Publisher("Omega Printing", "Bolivar 22", "Chacabuco", "Neuquen", "1556");

        publisherRepository.save(omega);


        Author erick = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        erick.getBooks().add(ddd);
        ddd.getAuthors().add(erick);

        ddd.setPublisher(omega);
        omega.getBooks().add(ddd);

        authorRepository.save(erick);
        bookRepository.save(ddd);
        publisherRepository.save(omega);


        Author rod = new Author("Rod", "Jonhson");
        Book ssb = new Book("Spring Something Book", "2345");
        rod.getBooks().add(ssb);
        ssb.getAuthors().add(rod);

        ssb.setPublisher(omega);
        omega.getBooks().add(ssb);

        authorRepository.save(rod);
        bookRepository.save(ssb);
        publisherRepository.save(omega);


        System.out.println("Starting from Bootstrap");
        System.out.println("Book are: " + bookRepository.count());

        System.out.println("Publisher count: " + publisherRepository.count());
        System.out.println(omega.toString());

    }
}
