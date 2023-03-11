package com.assignment.BookController.repository;

import com.assignment.BookController.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookJPARepository extends JpaRepository<Books, Integer> {

    List<Books> findByBookName(String bookName);

    //int deleteByBookName(String bookName);
}
