package org.example.domain.usecases.utils;

//criada para quando tentar inserir uma entidade e ela já existir no banco
public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
