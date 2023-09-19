package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@Controller

public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "index", method = RequestMethod.GET)

    public String mainPage() {

        return "bookThymeleaf";
    }

    @RequestMapping(value = "booklist", method = RequestMethod.GET)
    public String listAllBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "booklist";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

}
