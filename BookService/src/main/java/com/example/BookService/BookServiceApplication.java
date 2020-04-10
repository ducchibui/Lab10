package com.example.BookService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}

@Component
class ItemInitializer implements CommandLineRunner {

    private IBookRepository repo;
    public ItemInitializer(IBookRepository _repo) {
        this.repo = _repo;
    }
    @Override
    public void run(String... args) throws Exception {
        for (int i=1; i<=5; i++) {
            Book book = new Book();
            book.setTitle("Book " + i);
            book.setAuthor("Author " + i);
            book.setDescription("Description " + i);
            
            repo.save(book);
        }
        
        repo.findAll().forEach(System.out::println);    
    }
}