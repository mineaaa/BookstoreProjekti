package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean

	public CommandLineRunner bookStore(BookRepository bookStoreRepository, CategoryRepository categoryRepository,
			UserRepository userepository) {
		return (args) -> {

			Category c1 = new Category("Komedia");
			categoryRepository.save(c1);
			Category c2 = new Category("Seikkailu");
			categoryRepository.save(c2);

			log.info("kirjojen tallettaminen");
			bookStoreRepository.save(new Book("Minni Hiiri", "Minni Hiiren seikkailut", 2023, "hiiri123", 13.99, c1));
			bookStoreRepository.save(new Book("Mikki Hiiri", "Hiiren elämä", 2022, "hiiri234", 10.50, c2));

			for (Book book : bookStoreRepository.findAll()) {
				log.info(book.toString());
			}

			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			// käyttäjien luonti minea/minea ja admin/admin
			User user1 = new User("minea", "$2a$10$buuyprkNQrPlVZkvxbQSPOniEs/r9Yo8jIIyyUKzdIgEM7xrI71Te",
					"minea@haagahelia.fi", "USER");
			User user2 = new User("admin", "$2a$10$rYqlcWF7dRlMoqWYe5UXe.GBEOReOdU4.6nkeVeUE8LOCghxdwf7q",
					"admin@haagahelia.fi", "ADMIN");
			userepository.save(user1);
			userepository.save(user2);
		};
	}

}
