package com.mall.common.exception;

/**
 * @author bryin
 * @create 2020-05-24 11:11
 */
public class ParamException extends RuntimeException{
    public ParamException() {
    }
    public ParamException(String message) {
        super(message);
    }
}
