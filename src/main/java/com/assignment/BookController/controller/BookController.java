package com.assignment.BookController.controller;

import com.arch.assingment.instance.PageNotFound;
import com.assignment.BookController.exception.BookNotFound;
import com.assignment.BookController.model.Books;
import com.assignment.BookController.service.BookService;
import com.myfirstproj.demo.hello.model.User;
import com.myfirstproj.demo.hello.service.UserJPAService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/jpa")
@Slf4j
public class BookController {


    @Autowired
    BookService bookService;

    @Autowired
    private HttpServletRequest request;
    @PostMapping(path = "/books")
    public ResponseEntity<Books> createBook(@Valid @RequestBody Books books){
        if(books==null) return  ResponseEntity.internalServerError().body(books);
        Books newBook = bookService.addBook(books);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(books.getId())
                .toUri();
        // get a specific user
        return ResponseEntity.created(uri).body(books);
    }

     @GetMapping(value = "/books/{bookName}")
        public ResponseEntity<List<Books>> getSpecificUser(@RequestParam String bookName) throws BookNotFound {
            ResponseEntity<List<Books>> book = bookService.getBooksByName(bookName);
            if(book.getBody().isEmpty() )
                 throw new BookNotFound("Book Not found");
            return bookService.getBooksByName(bookName);
        }

    @GetMapping(path = "/books")
    public List<Books> getAllUsers(){
        return bookService.retrieveAllBooks();
    }

    @DeleteMapping(path="/book/{bookName}")
    public ResponseEntity deleteUser(@PathVariable String bookName){
        bookService.deleteBook(bookName);

        return ResponseEntity.noContent().build();
    }
}
