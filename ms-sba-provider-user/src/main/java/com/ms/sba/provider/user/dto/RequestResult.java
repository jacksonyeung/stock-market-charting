package com.ms.sba.provider.user.dto;

import lombok.Data;

@Data
public class RequestResult<T> {

    public static final String SUCCESS = "0000";
    public static final String UNAUTHORIZED = "E001";
    public static final String CONFLICT_USERNAME = "E002";
    public static final String CONFLICT_EMAIL = "E003";

    private String code;
    private T data;

}
