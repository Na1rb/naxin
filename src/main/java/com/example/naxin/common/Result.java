package com.example.naxin.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;    // 状态码
    private String message;  // 消息
    private T data;         // 数据

    // 成功返回
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    // 失败返回
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(String message) {
        return error(500, message);
    }

    // 参数错误
    public static <T> Result<T> paramError(String message) {
        return error(400, message);
    }

    // 未找到
    public static <T> Result<T> notFound(String message) {
        return error(404, message);
    }

    // 业务错误
    public static <T> Result<T> businessError(String message) {
        return error(409, message);
    }
}
