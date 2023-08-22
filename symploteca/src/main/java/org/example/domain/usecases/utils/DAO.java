package org.example.domain.usecases.utils;

import java.util.List;
import java.util.Optional;

public interface DAO <T,K>{ //T é o tipo persistido(book, user, transaction) no banco e K é o tipo da chave
    //retorna um tipo K de chave (por exemplo um int) e recebe o tipo a ser persistido no banco
    K create(T type);

    //retorna um tipo T e recebe como parâmetro a chave do elemento a ser retornado
    //se fosse retornaro um null na seguinte situação -> T findOne(K key) eu receberia uma nullPointerExpection
    //o Optional é uma classe generics que reecebe um tipo, no caso ele espera que seja retornado pelo método findOne o tipo T
    //porém o Optional<> dá flexibilidade para que seja retornado um null, e caso isso ocorra ele retorna algo que
    //não é um nullPointerExpection, e que será visto depois
    //resumidamente, o Optional me proteje de um retorno null em um lugar que não pode acontecer porque geraria uma nullPointerExpection
    Optional<T> findOne(K key);

    //retorna uma lista de um tipo T
    //aqui eu não preciso usar Optional porque se a lista vier vazia não é a mesma coisa que um null
    List<T> findAll();

    //retorna um booleano indicadno se o update deu certo e recebe o tipo a ser atualizado (livro, usuario, transação)
    boolean update(T type);

    //retorna um booleano indicando se a operação foi realizada e recebe a chave do objeto a ser deletado
    boolean deleteByKey(K key);

    //é uma alternativa ao de cima, porém ao invés de receber a chave ele recebe o objeto todo
    boolean delete(T type);

}
