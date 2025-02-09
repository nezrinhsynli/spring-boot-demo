package com.nezrinhuseynli.spring_data_jpa.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    NO_RECORD_EXIST(101, "No student record found!"),
    UNKNOWN_ERROR(999,"Unknown Error");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

}

