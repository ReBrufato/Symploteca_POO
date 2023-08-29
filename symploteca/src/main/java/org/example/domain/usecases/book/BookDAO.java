package org.example.domain.usecases.book;

import org.example.domain.entities.book.Book;
import org.example.domain.usecases.utils.DAO;

import java.util.Optional;

public interface BookDAO extends DAO<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);
}
