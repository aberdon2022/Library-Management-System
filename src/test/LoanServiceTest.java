package test;

import models.Book;
import models.User;
import org.junit.Test;
import services.BookService;
import services.LoanService;
import services.UserService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoanServiceTest {

    @Test
    public void loanAndReturnBook() {
        BookService bookService = new BookService();
        UserService userService = new UserService();
        LoanService loanService = new LoanService();

        Book book = new Book("1984", "George Orwell", "123456789");
        User user = new User("Alice", "U001");

        bookService.addBook(book);
        userService.registerUser(user);
        loanService.loanBook(user, book);

        assertFalse(book.isAvailable());

        loanService.returnBook(user, book);
        assertTrue(book.isAvailable());
    }
}
