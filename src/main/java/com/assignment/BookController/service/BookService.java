package com.assignment.BookController.service;

import com.assignment.BookController.model.Books;
import com.assignment.BookController.repository.BookJPARepository;
import com.myfirstproj.demo.hello.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookService {

    @Autowired
    BookJPARepository bookJPARepository;
    public static ArrayList<User> users = new ArrayList<>();
    public static int id = 0;

    public Books addBook(Books book) {
        Books addNewBook = bookJPARepository.save(book);
        return addNewBook;
    }

    public ResponseEntity<List<Books>> getBooksByName(@RequestParam String bookName) {
               return new ResponseEntity<List<Books>>(bookJPARepository.findByBookName(bookName), HttpStatus.OK);
    }
    public List<Books> retrieveAllBooks() {
        return bookJPARepository.findAll();
    }

    public void deleteBook(String bookName) {
        // user is present or not then delete
     List<Books> booklist= bookJPARepository.findByBookName(bookName);
        bookJPARepository.deleteAll(booklist);
      // log.info("Delete record count::"+i);
        //  users.removeIf(x -> x.getId() == userId);
    }
}
