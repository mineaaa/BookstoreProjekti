package hh.sof03.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    @ManyToOne
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
        this.author = null;
        this.title = null;
        this.year = 0;
        this.isbn = null;
        this.price = 0;
        this.category = null;
    }

    public Book(String author, String title, int year, String isbn, double price, Category category) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null) {
            return "Book [author=" + author + ", title=" + title + ", year=" + year + ", isbn=" + isbn + ", price="
                    + price + "category=" + category + "]";
        } else {
            return "Book [author=" + author + ", title=" + title + ", year=" + year + ", isbn=" + isbn + ", price="
                    + price + "]";
        }

    }

}
