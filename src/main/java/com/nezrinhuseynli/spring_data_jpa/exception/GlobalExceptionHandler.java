package com.nezrinhuseynli.spring_data_jpa.exception;

import com.nezrinhuseynli.spring_data_jpa.dto.response.ErrorResponse;
import com.nezrinhuseynli.spring_data_jpa.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        ErrorResponse<String> errorResponse = new ErrorResponse<>();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorCode(ErrorCodeEnum.NO_RECORD_EXIST.getCode());
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponse<String> handleException(Exception e) {
        ErrorResponse<String> errorResponse = new ErrorResponse<>();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setErrorCode(ErrorCodeEnum.UNKNOWN_ERROR.getCode());
        errorResponse.setMessage(e.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse<Map<String, List<String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errorMap = new HashMap<>();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            FieldError field = (FieldError) objectError;
            String fieldName = field.getField();
            if (!errorMap.containsKey(fieldName)) {
                errorMap.put(fieldName, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
            } else {
                errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), objectError.getDefaultMessage()));
            }
        }

        ErrorResponse<Map<String, List<String>>> errorResponse = new ErrorResponse<>();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(errorMap);
        return errorResponse;
    }

    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

}
