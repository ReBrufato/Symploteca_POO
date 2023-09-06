package org.example.domain.usecases.user;

import org.example.domain.entities.book.Book;
import org.example.domain.entities.user.User;
import org.example.domain.usecases.utils.DAO;

import java.util.Optional;

public interface UserDAO extends DAO<User, String> {
    Optional<User> findByEmail(String email);
}
