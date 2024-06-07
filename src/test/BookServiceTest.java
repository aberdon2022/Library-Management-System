package test;

import exceptions.BookNotFoundException;
import models.Book;
import org.junit.Test;
import services.BookService;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

public class BookServiceTest {
    @Test
    public void addAndFindBook() throws BookNotFoundException {
        BookService bookService = new BookService();
        Book book = new Book("1984", "George Orwell", "123456789");
        bookService.addBook(book);

        Book foundBook = bookService.findBook("123456789");
        assertEquals("1984", foundBook.getTitle());
    }

    @Test
    public void removeBook() throws BookNotFoundException {
        BookService bookService = new BookService();
        Book book = new Book("1984", "George Orwell", "123456789");
        bookService.addBook(book);

        bookService.removeBook("123456789");
        assertThrows(BookNotFoundException.class, () -> bookService.findBook("123456789"));
    }
}
