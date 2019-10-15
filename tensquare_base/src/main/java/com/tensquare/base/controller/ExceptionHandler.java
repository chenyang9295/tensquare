package com.tensquare.base.controller;

import entity.Result;

import entity.StatusCode;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  //所有Controller类异常类处理注解
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Result exception(Exception e)
    {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
