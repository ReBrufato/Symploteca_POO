package org.example.domain.usecases.utils;

import java.util.List;
import java.util.Optional;

public interface DAO <T,K>{ //T é o tipo persistido(book, user, transaction) no banco e K é o tipo da chave
    K create(T type);

    Optional<T> findOne(K key);

    List<T> findAll();

    boolean update(T type);

    boolean deleteByKey(K key);

    boolean delete(T type);

}
