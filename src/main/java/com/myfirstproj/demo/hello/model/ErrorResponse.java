package com.myfirstproj.demo.hello.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data

public class ErrorResponse {


    private int code;
    private String message;
    private String details;
    private LocalDate timeStamp;
}
