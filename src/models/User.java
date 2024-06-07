package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userID;
    private List<Loan> loans;

    public User(String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.loans = new ArrayList<>();
    }

    public void addLoan (Loan loan) {
        this.loans.add(loan);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
