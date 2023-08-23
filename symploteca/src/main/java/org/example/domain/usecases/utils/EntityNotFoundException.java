package org.example.domain.usecases.utils;

//criada para quando não for encontrada uma entidade
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
