package org.example.domain.entities.transaction;

import org.example.domain.entities.book.Book;
import org.example.domain.entities.user.User;

import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private LocalDate issueDate;
    private  LocalDate dueDate;
    private LocalDate returnDate;
    private Book book;
    private User user;

    public Transaction(Book book, User user, int numberOfCheckoutDays) {
        this.book = book;
        this.user = user;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(numberOfCheckoutDays); //incrementa o n° de dias que o livro ficará emprestado ao dia de empréstimo
    }

    public Transaction(Integer id, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate, Book book, User user) {
        this.id = id;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.book = book;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}
