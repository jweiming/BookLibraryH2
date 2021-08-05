//package com.booklibrary.unittest.controller;
//
//import com.booklibrary.api.v1.controller.BookController;
//import com.booklibrary.domain.model.Book;
//import com.booklibrary.dto.BookDto;
//import com.booklibrary.exception.EntityNotFoundException;
//import com.booklibrary.service.book.BookService;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.doThrow;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(BookController.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class BookControllerMockMvcStandaloneTest {
//
//    @Autowired
//    private ModelMapper mapper;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BookService bookService;
//
//
//    @Before
//    public void setup(){}
//
//    /**
//     * Get all books unit-test.
//     * The unit test should result in returning the 2 books which are provided by us as input.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void ut1_GetAllBooks() throws Exception{
//        List<Book> books = new ArrayList<>(2);
//        books.add(new Book()
//                .setTitle("testTitle")
//                .setAuthor("testAuthor")
//                .setDescription("testDescription")
//                .setIsbn("1234567"));
//        books.add(new Book()
//                .setTitle("testTitle2")
//                .setAuthor("testAuthor2")
//                .setDescription("testDescription2")
//                .setIsbn("12345672"));
//
//        // Mocking response
//        doReturn(books).when(bookService).getAllBooks();
//
//        // Expect the mock response
//        mockMvc
//                .perform(MockMvcRequestBuilders.get("/v1/books/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andDo(print());
//    }
//
//    /**
//     * Get Book by bookId unit-test.
//     * The test should result in returning Book details for SSN:1 as provided by us as input.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void ut2_GetBookById() throws Exception{
//        Long bookId = new Long(1);
//        Book book = new Book()
//                .setBookId(bookId)
//                .setTitle("testTitle2")
//                .setAuthor("testAuthor2")
//                .setDescription("testDescription2")
//                .setIsbn("12345672");
//
//        // Mocking response
//        doReturn(book).when(bookService).getBook(bookId);
//
//        // Expect the mock response
//        // note: rating and pageCount is not returned as it is null
//        mockMvc
//                .perform(MockMvcRequestBuilders.get("/v1/books/" + bookId).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.bookId").exists())
//                .andExpect(jsonPath("$.title").exists())
//                .andExpect(jsonPath("$.author").exists())
//                .andExpect(jsonPath("$.description").exists())
//                .andExpect(jsonPath("$.isbn").exists())
//                .andExpect(jsonPath("$.bookId").value(bookId))
//                .andExpect(jsonPath("$.title").value("testTitle2"))
//                .andExpect(jsonPath("$.author").value("testAuthor2"))
//                .andExpect(jsonPath("$.description").value("testDescription2"))
//                .andExpect(jsonPath("$.isbn").value("12345672"))
//                .andDo(print());
//
//    }
//
//    /**
//     * Get Book by invalid bookId unit-test.
//     * The test should result in returning a Http 404 for a Book with invalid bookId.
//     *
//     * @throws Exception
//     */
//    @Test
//    public void ut3_GetBookByInvalidId() throws Exception {
//
//        // Mock Response
//        doThrow(new EntityNotFoundException(Book.class, "bookId", "2")).when(bookService).getBook(2L);
//
//        // Expect the mock response
//        mockMvc
//                .perform(MockMvcRequestBuilders.get("/v1/books/2").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.apierror.status").value("NOT_FOUND"))
//                .andExpect(jsonPath("$.apierror.message").value("Book was not found for parameters {bookId=2}"))
//                .andDo(print());
//    }
//
//    /**
//     * Create Book unit-test.
//     * The test should result in adding a new Book with bookId:1
//     *
//     * @throws Exception
//     */
//    @Test
//    public void ut4_CreateBook() throws Exception{
//        Book book = new Book()
//                .setTitle("testTitle")
//                .setAuthor("testAuthor")
//                .setDescription("testDescription")
//                .setIsbn("1234567");
//
//        // Mock response
//        doReturn(book).when(bookService).createBook(mapper.map(book, BookDto.class));
//
//        // Expect the mock response
//        mockMvc
//                .perform(MockMvcRequestBuilders.post("/v1/books/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"title\":\"testTitle\", \"author\":\"testAuthor\",\"description\":\"testDescription\",\"isbn\":\"1234567\"}")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    /**
//     * Update Book unit-test.
//     * The test should result in updating a new Book with bookId:1
//     *
//     * @throws Exception
//     */
//    @Test
//    public void ut5_UpdateBook() throws Exception{
//        Book updatedBook = new Book()
//                .setBookId(1L)
//                .setTitle("testTitle2")
//                .setAuthor("testAuthor2")
//                .setDescription("testDescription2")
//                .setIsbn("1234567");
//
//        // Mock response
//        doReturn(updatedBook).when(bookService).createBook(mapper.map(updatedBook, BookDto.class));
//
//        // Expect the mock response
//        mockMvc
//                .perform(MockMvcRequestBuilders.put("/v1/books/update")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"bookId\":\"1\",\"title\":\"testTitle2\", \"author\":\"testAuthor2\",\"description\":\"testDescription2\",\"isbn\":\"1234567\"}")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    /**
//     * Delete Book unit-test.
//     * The test should result in deleting a Book with bookId:1
//     *
//     * @throws Exception
//     */
//    @Test
//    public void ut5_DeleteBook() throws Exception{
//        mockMvc
//                .perform(MockMvcRequestBuilders.delete("/v1/books/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//}
