package com.assignment.BookController.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity(name="Book_Details")
public class Books {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    public int id;

    public String bookName;
    public double bookPrice;
    public double discountedPrice;
    public LocalDate publishedDate;
}
