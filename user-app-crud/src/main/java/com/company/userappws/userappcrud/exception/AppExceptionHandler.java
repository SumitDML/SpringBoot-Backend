package com.company.userappws.userappcrud.exception;

import com.company.userappws.userappcrud.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex , WebRequest request){
        String ErrorMessageDescription = ex.getLocalizedMessage();
        if(ErrorMessageDescription == null)ErrorMessageDescription = ex.toString();

        ErrorMessage errormessage = new ErrorMessage(new Date(),ErrorMessageDescription );


        return new ResponseEntity<>(
                errormessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
