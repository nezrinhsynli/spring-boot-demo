package com.nezrinhuseynli.spring_data_jpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse<T> {

    private LocalDateTime timestamp;
    private Integer status;
    private Integer errorCode;
    private T message;

}
