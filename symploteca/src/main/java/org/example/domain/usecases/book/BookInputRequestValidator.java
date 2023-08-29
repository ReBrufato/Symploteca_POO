package org.example.domain.usecases.book;

import org.example.domain.entities.book.Book;
import org.example.domain.usecases.utils.Notification;
import org.example.domain.usecases.utils.Validator;

public class BookInputRequestValidator extends Validator<Book> {

    @Override
    public Notification validate(Book book) {
        Notification notification = new Notification();

        if (book == null){
            notification.addError("Book is null");
            return notification;
        }

        if(nullOrEmpty(book.getName())) notification.addError("Name is null or empty");
        if(nullOrEmpty(book.getIsbn())) notification.addError("ISBN is null or empty");
        if(nullOrEmpty(book.getAuthors())) notification.addError("Authors are null or empty");
        if(nullOrEmpty(book.getPublisher())) notification.addError("Publisher is null or empty");

        return notification;
    }
}
