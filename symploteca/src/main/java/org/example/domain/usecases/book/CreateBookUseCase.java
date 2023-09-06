package org.example.domain.usecases.book;

import org.example.domain.entities.book.Book;
import org.example.domain.usecases.utils.EntityAlreadyExistsException;
import org.example.domain.usecases.utils.Notification;
import org.example.domain.usecases.utils.Validator;

public class CreateBookUseCase {

    private BookDAO bookDAO;

    public CreateBookUseCase(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public Integer insert(Book book){
        Validator<Book> validator = new BookInputRequestValidator();
        Notification notification = validator.validate(book);

        if(notification.hasError()) throw new IllegalArgumentException(notification.errorMessage());

        if(bookDAO.findByIsbn(book.getIsbn()).isPresent()) throw new EntityAlreadyExistsException("This ISBN is already in use.");

        return bookDAO.create(book);
    }
}
