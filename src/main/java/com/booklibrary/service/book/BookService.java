package com.booklibrary.service.book;

import com.booklibrary.domain.model.Book;
import com.booklibrary.dto.BookDto;
import com.booklibrary.exception.EntityException;
import com.booklibrary.exception.EntityNotFoundException;

import java.util.List;

/**
 * Created by Joseph
 * Basic CRUD functionality
 */
public interface BookService {
    Book createBook (BookDto bookDto) throws EntityException;

    Book updateBook (BookDto bookDto) throws EntityException;

    Book getBook(Long bookId) throws EntityNotFoundException;

    void deleteBook(Long bookId) throws EntityNotFoundException;

    List<Book> getAllBooks();
}
