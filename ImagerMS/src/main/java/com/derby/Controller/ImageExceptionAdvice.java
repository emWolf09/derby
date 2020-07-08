package com.derby.Controller;

import com.derby.CustomException.CustomExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ImageExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomExceptionMessage> handleParent(Exception exception){
        CustomExceptionMessage customException = new CustomExceptionMessage();
        System.out.println("--------------------");
        exception.printStackTrace();
        System.out.println("--------------------");
        customException.setMessage(exception.getMessage());
        return new ResponseEntity<CustomExceptionMessage>(customException, HttpStatus.NOT_FOUND);
    }
}
