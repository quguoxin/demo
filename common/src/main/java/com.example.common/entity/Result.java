package com.example.common.entity;

import com.example.common.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-09-22 15:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private String code;

    private String message;

    private T data;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ErrorCode.SUCCESS.getCode());
        result.setMessage(ErrorCode.SUCCESS.getErrMsg());
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(ErrorCode errorCode) {
        return new Result(errorCode.getCode(), errorCode.getErrMsg());
    }

    public static Result fail(String code, String message) {
        return new Result(code, message);
    }
}
