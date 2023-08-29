package org.example.domain.usecases.book;

import org.example.domain.entities.book.Book;
import org.example.domain.usecases.utils.Validator;

import java.util.List;
import java.util.Optional;

public class FindBookUseCase {
    private BookDAO bookDAO;

    public FindBookUseCase(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    //verifica se o id do livro é null, se for é levantada uma exceção
    public Optional<Book> findOne(Integer id) {
        if (id == null) throw new IllegalArgumentException("ID can not be null.");
        return bookDAO.findOne(id);
    }

    //verifica se o isbn é null ou vazio, se for levanta uma exceção
    public Optional<Book> findOneByIsbn(String isbn){
        if(Validator.nullOrEmpty(isbn)) throw new IllegalArgumentException("ESBN can not be null or empty.");
        return bookDAO.findByIsbn(isbn);
    }

    public List<Book> findAll(){
        return bookDAO.findAll();
    }
}
