package org.example.domain.usecases.user;

import org.example.domain.entities.user.User;
import org.example.domain.usecases.utils.EntityNotFoundException;
import org.example.domain.usecases.utils.Notification;
import org.example.domain.usecases.utils.Validator;

public class UpdateUserUseCase {
    private UserDAO userDAO;

    public UpdateUserUseCase(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public Boolean update(User user){
        Validator<User> validator = new UserInputRequestValidator();
        Notification notification = validator.validate(user);

        if(notification.hasError()) throw new IllegalArgumentException(notification.errorMessage());

        if(userDAO.findOne(user.getInstitutionalId()).isEmpty()) throw new EntityNotFoundException("User not found.");

        return userDAO.update(user);
    }
}
