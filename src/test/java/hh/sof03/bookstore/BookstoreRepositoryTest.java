package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test // testataan kaikkien kirjojen listaaminen
    public void listingAllBooks() {
        assertThat(bookRepository.findAll());
    }

    @Test // testataan kirjan poistaminen id:llä
    public void deleteBookById() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        bookRepository.deleteById((long) 1);
        books = (List<Book>) bookRepository.findAll();
        assertThat(books).hasSize(1);

    }

    @Test // testataan kirjan lisääminen controllerin save-metodilla
    public void createNewBook() {
        Book book = new Book("Iines Ankka", "Ankka tarina", 2019, "ankka678", 25.99, null);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test // testataan löytyykö kirjan otsikolla kirjailijan nimi
    public void findByNameBook() {
        List<Book> books = bookRepository.findByTitle("Minni Hiiren seikkailut");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Minni Hiiri");
    }

    @Test // testataan kaikkien kategorioiden listaamista
    public void listAllCategories() {
        assertThat(categoryRepository.findAll());

    }

    @Test // testataan uuden kategorian luomista savecategoryn avulla
    public void createNewCategory() {
        Category category = new Category("Jännitys");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();

    }

    @Test // testataan kategorian poistamista id:llä
    public void deleteCategorybyId() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        categoryRepository.deleteById((long) 1);
        categories = (List<Category>) categoryRepository.findAll();
        assertThat(categories).hasSize(1);

    }

    @Test // testataan kategorian etsimistä nimellä
    public void findByNameCategory() {
        List<Category> categories = categoryRepository.findByName("Komedia");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryId()).isEqualTo(1);
    }

    @Test // testataan kaikkien käyttäjien listaaminen
    public void listAllUsers() {
        assertThat(userRepository.findAll());
    }

    @Test // testataan käyttäjänimellä löytämistä
    public void findByNameUser() {
        List<User> users = userRepository.findByUsername("minea");
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getEmail()).isEqualTo("minea@haagahelia.fi");

    }

    @Test // testataan uuden käyttäjän luomista
    public void saveNewUser() {
        User u3 = new User("user", "$2a$10$1a8KO6xK3eoYcnGHZ4UHLOYfKr3.sHbtBzpXZdgL8skDCHYnSkl8W", "user@haagahelia.fi",
                "USER");
        userRepository.save(u3);
        assertThat(u3.getId()).isNotNull();
    }

    @Test // testataan käyttäjän poistamista id:llä
    public void deleteUserbyId() {
        List<User> users = (List<User>) userRepository.findAll();
        userRepository.deleteById((long) 1);
        users = (List<User>) userRepository.findAll();
        assertThat(users).hasSize(1);

    }

}
