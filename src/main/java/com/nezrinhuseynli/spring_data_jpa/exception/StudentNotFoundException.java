package com.nezrinhuseynli.spring_data_jpa.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }

}
