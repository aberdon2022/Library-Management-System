package services;

import exceptions.BookNotFoundException;
import models.Book;

import java.util.HashMap;
import java.util.Map;

public class BookService {
    private Map<String, Book> books;

    public BookService() {
        this.books = new HashMap<>();
    }

    public void addBook (Book book) {
        this.books.put(book.getISBN(), book);
    }

    public Book findBook (String ISBN) throws BookNotFoundException {
        Book book = this.books.get(ISBN);

        if (book == null) {
            throw new BookNotFoundException("Book not found " + ISBN);
        }
        return book;
    }

    public void removeBook (String ISBN) throws BookNotFoundException {
        if (books.remove(ISBN) == null) {
            throw new BookNotFoundException("Book not found " + ISBN);
        }
    }
}
