package com.tensquare.split.controllelr;


import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 所有Controller类出现异常的拦截器
 *
 */
@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result Exception()
    {
        return new Result(false, StatusCode.ERROR,"执行出错");
    }
}
