package hh.sof03.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String author;
    private String title;
    @Column(name = "publishing_year")
    private int year;
    private String isbn;
    private double price;

    public Book() {
        this.author = null;
        this.title = null;
        this.year = 0;
        this.isbn = null;
        this.price = 0;
    }

    public Book(String author, String title, int year, String isbn, double price) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", title=" + title + ", year=" + year + ", isbn=" + isbn + ", price=" + price
                + "]";
    }

}
