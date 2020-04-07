package guru.springframework.bootstrap;

import guru.springframework.domain.Author;
import guru.springframework.domain.Book;
import guru.springframework.repository.AuthorRepository;
import guru.springframework.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noejb = new Book("JZEE Development without EJB", "2346530");
        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noejb);

        System.out.println("Started In Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
    }
}
