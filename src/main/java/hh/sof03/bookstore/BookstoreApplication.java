package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean

	public CommandLineRunner bookStore(BookRepository bookStoreRepository) {
		return (args) -> {

			log.info("kirjojen tallettaminen");
			bookStoreRepository.save(new Book("Minni Hiiri", "Minni Hiiren seikkailut", 2023, "hiiri123", 13.99));
			bookStoreRepository.save(new Book("Mikki Hiiri", "Hiiren elämä", 2022, "hiiri234", 10.50));

			for (Book book : bookStoreRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

	@Bean

	public CommandLineRunner categoryBookStore(CategoryRepository categoryRepository) {
		return (args) -> {

			log.info("kategorioiden tallettaminen");
			categoryRepository.save(new Category("Elämänkerta"));
			categoryRepository.save(new Category("Komedia"));

			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
		};
	}

}
