package com.booklibrary.service.book;

import com.booklibrary.domain.model.Book;
import com.booklibrary.domain.repository.BookRepository;
import com.booklibrary.dto.BookDto;
import com.booklibrary.exception.DuplicateEntityException;
import com.booklibrary.exception.EntityException;
import com.booklibrary.exception.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Joseph
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Book createBook(BookDto bookDto) throws EntityException {
        Optional<Book> bookWithSameIsbn = Optional.ofNullable(bookRepository.findByIsbn(bookDto.getIsbn()));
        if (bookWithSameIsbn.isPresent()) {
            throw new DuplicateEntityException(Book.class, "isbn", bookDto.getIsbn().toString());
        }
        Book newBook = mapper.map(bookDto, Book.class);
        return bookRepository.save(newBook);
    }

    @Override
    public Book updateBook(BookDto bookDto) throws EntityException {
        Optional<Book> newBook = bookRepository.findById(bookDto.getBookId());
        if (newBook.isPresent()) {
            Book book = mapper.map(bookDto, Book.class);
            return bookRepository.save(book);
        }
        throw new EntityNotFoundException(Book.class, "bookId", bookDto.getBookId().toString());
    }

    @Override
    public Book getBook(String bookId) throws EntityNotFoundException {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            return existingBook.get();
        }
        throw new EntityNotFoundException(Book.class, "bookId", bookId.toString());
    }

    @Override
    public void deleteBook(String bookId) throws EntityNotFoundException {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            bookRepository.delete(existingBook.get());
        } else {
            throw new EntityNotFoundException(Book.class, "bookId", bookId.toString());
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (!books.isEmpty()) {
            return books;
        }
        return Collections.emptyList();
    }

}
