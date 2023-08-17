package org.example.domain.entities.user;

//criação de exceção própria
public class IlegalNumberOfCheckedOutItensException extends RuntimeException{
    public IlegalNumberOfCheckedOutItensException(String message) {
        super(message);
    }
}
