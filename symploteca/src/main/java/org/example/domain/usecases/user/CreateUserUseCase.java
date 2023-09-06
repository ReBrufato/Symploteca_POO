package org.example.domain.usecases.user;

import org.example.domain.entities.book.Book;
import org.example.domain.entities.user.User;
import org.example.domain.usecases.utils.EntityAlreadyExistsException;
import org.example.domain.usecases.utils.Notification;
import org.example.domain.usecases.utils.Validator;

public class CreateUserUseCase {

    private UserDAO userDAO;

    public CreateUserUseCase(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public String insert(User user){
        Validator<User> validator = new UserInputRequestValidator();
        Notification notification = validator.validate(user);

        if(notification.hasError()) throw new IllegalArgumentException(notification.errorMessage());

        if(userDAO.findByEmail(user.getEmail()).isPresent()) throw new EntityAlreadyExistsException("This Email is already in use.");

        return userDAO.create(user);
    }
}
