package com.example.common.exception;

import com.example.common.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-09-22 15:28
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlers {

    @ExceptionHandler(CustomException.class)
    public Result handleCustomException(CustomException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }


}
