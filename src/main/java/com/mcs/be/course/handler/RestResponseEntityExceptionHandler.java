package com.mcs.be.course.handler;

import com.mcs.be.course.dto.ApiError;
import com.mcs.be.course.exception.ElementNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by mcolombo on 12/12/17.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ElementNotFound.class })
    protected @ResponseBody ResponseEntity<Object> handleElementNotFound(Exception ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.OK, ex.getMessage(), ex.getClass().getName());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.OK, request);
    }


    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected @ResponseBody ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.CONFLICT,ex.getMessage(), ex.getClass().getName());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
