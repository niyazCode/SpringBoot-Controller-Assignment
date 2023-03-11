package com.myfirstproj.demo.hello.exception;

import com.myfirstproj.demo.hello.model.ErrorResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {

   @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request
    ) {
       List<String> errors = ex.getFieldErrors().stream().map(x-> x.getDefaultMessage()).collect(Collectors.toList());
        ErrorResponse errorResponse = ErrorResponse.builder().code(status.value()).timeStamp(LocalDate.from(LocalDateTime.now()))
                //.message(ex.getFieldErrors().stream().findFirst().get().getDefaultMessage())
                //.details(request.getDescription(false)).build();
                .message(errors.toString())
                .details(request.getDescription(false
                )).build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
