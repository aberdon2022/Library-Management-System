import exceptions.BookNotFoundException;
import exceptions.UserNotFoundException;
import models.Book;
import models.User;
import services.BookService;
import services.LoanService;
import services.UserService;

public class Main {
    public static void main(String[] args) {

        BookService bookService = new BookService();
        UserService userService = new UserService();
        LoanService loanService = new LoanService();

        // Sample data
        Book book1 = new Book("1984", "George Orwell", "123456789");
        User user1 = new User("Alice", "U001");

        // Adding book and user
        bookService.addBook(book1);
        userService.registerUser(user1);

        // Loaning a book
        try {
            Book foundBook = bookService.findBook("123456789");
            User foundUser = userService.findUser("U001");
            loanService.loanBook(foundUser, foundBook);
        } catch (BookNotFoundException | UserNotFoundException e) {
            e.printStackTrace();
        }

        // Returning a book
        loanService.returnBook(user1, book1);
    }
}