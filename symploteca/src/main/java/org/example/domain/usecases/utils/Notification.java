package org.example.domain.usecases.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notification {

    private List<Error> errors = new ArrayList<>();

    public void addError(String message){
        addError(message, null);
    }

    public void addError(String message, Exception e){
        addError(message, e);
    }

    public boolean isCorrect(){
        return errors.isEmpty();
    }

    public boolean hasError(){
        return ! isCorrect();
    }

    private static class Error{
        String message;
        Exception cause;

        public Error(String message, Exception cause) {
            this.message = message;
            this.cause = cause;
        }
    }

    public String errorMesage(){
        return errors.stream()
                .map(error -> error.message)
                .collect(Collectors.joining(" ,"));
    }
}
