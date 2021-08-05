package com.booklibrary.service.book;

import com.booklibrary.domain.model.Book;
import com.booklibrary.dto.BookDto;
import com.booklibrary.exception.EntityException;
import com.booklibrary.exception.EntityNotFoundException;

import java.util.List;

/*
 * Basic CRUD functionality
 */
public interface BookService {
    Book createBook (BookDto bookDto) throws EntityException;

    Book updateBook (BookDto bookDto) throws EntityException;

    Book getBook(String bookId) throws EntityNotFoundException;

    void deleteBook(String bookId) throws EntityNotFoundException;

    List<Book> getAllBooks();
}
