package org.example.domain.entities.user;

public class IlegalNumberOfCheckedOutItensException extends RuntimeException{
    public IlegalNumberOfCheckedOutItensException(String message) {
        super(message);
    }
}
