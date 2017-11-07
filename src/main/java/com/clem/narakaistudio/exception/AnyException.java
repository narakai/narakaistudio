package com.clem.narakaistudio.exception;


import com.clem.narakaistudio.constant.ExceptionEnum;

/**
 * 统一异常
 */
public class AnyException extends RuntimeException {

    public AnyException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
    }

    public AnyException(String message){
        super(message);
    }

}
