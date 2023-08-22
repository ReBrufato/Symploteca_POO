package org.example.domain.usecases.utils;

import java.util.Collection;

//será implementada pelos casos de uso para validação de alguns dados dos objetos
public abstract class Validator<T> {
    public abstract Notification validate(T type);

    public static boolean nullOrEmpty(String string){
        return string == null || string.isEmpty();
    }

    public static boolean nullOrEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }
}
