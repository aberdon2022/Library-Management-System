package services;

import models.Book;
import models.Loan;
import models.User;
import utils.DateUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LoanService {
    private Queue<Loan> loans;

    public LoanService() {
        this.loans = new LinkedList<>();
    }

    public void loanBook (User user, Book book) {
        Loan loan = new Loan(book, user, DateUtils.calculateDueDate());
        user.addLoan(loan);
        book.setAvailable(false);
        loans.add(loan);
    }

    public Loan findLoan (User user, Book book) {
        for (Loan loan : loans) {
            if (loan.getUser().equals(user) && loan.getBook().equals(book)) {
                return loan;
            }
        }
        return null;
    }

    public void returnBook (User user, Book book) {
        Loan loan = findLoan(user, book);
        if (loan != null) {
            book.setAvailable(true);
            user.getLoans().remove(loan);
            this.loans.remove(loan);
            System.out.println("Book returned succesfully");
        } else {
            System.out.println("Loan not found. Unable to return the book.");
        }
    }
}
