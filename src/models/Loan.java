package models;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate localDate;

    public Loan(Book book, User user, LocalDate localDate) {
        this.book = book;
        this.user = user;
        this.localDate = localDate;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
