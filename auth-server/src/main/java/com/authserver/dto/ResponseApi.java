package com.authserver.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseApi {

    private String message;
    private Integer statusCode;
    private Object data;

}
