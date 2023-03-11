package com.arch.assingment.util;

import com.arch.assingment.instance.PageNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler {
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";
    private final MessageSource messageSource;

    @Autowired
    public AppExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
//    @ExceptionHandler(PageNotFound.class)
//    public ResponseEntity<String> handleArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
//        BindingResult result = ex.getBindingResult();
//        List<String> errorMessages = result.getAllErrors()
//                .stream()
//                .map(objectError -> messageSource.getMessage(objectError, locale))
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(errorMessages.get(0), HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(PageNotFound.class)
    public ResponseEntity<String> handleArgumentNotValidException(PageNotFound ex){
        return new ResponseEntity<>(messageSource.getMessage(ex.getMessage(),null, LocaleContextHolder.getLocale()), HttpStatus.BAD_REQUEST);
    }
}
