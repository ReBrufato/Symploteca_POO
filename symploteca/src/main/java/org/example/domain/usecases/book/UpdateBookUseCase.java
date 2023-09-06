package org.example.domain.usecases.book;

import org.example.domain.entities.book.Book;
import org.example.domain.usecases.utils.EntityAlreadyExistsException;
import org.example.domain.usecases.utils.EntityNotFoundException;
import org.example.domain.usecases.utils.Notification;
import org.example.domain.usecases.utils.Validator;

public class UpdateBookUseCase {
    private BookDAO bookDAO;

    public UpdateBookUseCase(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public Boolean update(Book book){
        Validator<Book> validator = new BookInputRequestValidator();
        Notification notification = validator.validate(book);

        if(notification.hasError()) throw new IllegalArgumentException(notification.errorMessage());

        if(bookDAO.findOne(book.getId()).isEmpty()) throw new EntityNotFoundException("Book not found.");

        return bookDAO.update(book);
    }
}
