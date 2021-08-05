package com.booklibrary.api.v1.controller;

import com.booklibrary.api.v1.request.book.CreateBookRequest;
import com.booklibrary.api.v1.request.book.UpdateBookRequest;
import com.booklibrary.domain.model.Book;
import com.booklibrary.dto.BookDto;
import com.booklibrary.exception.EntityException;
import com.booklibrary.exception.EntityNotFoundException;
import com.booklibrary.service.book.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/")
    public List<BookDto> getBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books != null && !books.isEmpty()) {
            return books
                    .stream()
                    .map(book -> modelMapper.map(book, BookDto.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @GetMapping(value = "/{id}")
    public BookDto getBookById(@PathVariable("id") String bookId) throws EntityNotFoundException {
        Book book = bookService.getBook(bookId);
        if (book != null) {
            return modelMapper.map(book, BookDto.class);
        }
        return null;
    }

    @PostMapping("/create")
    public BookDto createBook(@RequestBody @Valid CreateBookRequest createBookRequest) throws EntityException {
        BookDto bookDto = modelMapper.map(createBookRequest, BookDto.class);
        Book book = bookService.createBook(bookDto);
        if (book != null) {
            return modelMapper.map(book, BookDto.class);
        }
        return null;
    }

    @PutMapping("/update")
    public BookDto updateBook(@RequestBody @Valid UpdateBookRequest updateBookRequest) throws EntityException {
        BookDto bookDto = modelMapper.map(updateBookRequest, BookDto.class);
        Book book = bookService.updateBook(bookDto);
        if (book != null) {
            return modelMapper.map(book, BookDto.class);
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") String bookId) throws EntityNotFoundException {
        Book book = bookService.getBook(bookId);
        if (book != null) {
            bookService.deleteBook(bookId);
        }
    }
}
