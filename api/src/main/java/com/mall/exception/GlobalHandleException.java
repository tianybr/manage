package com.mall.exception;

import com.mall.common.JSONResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author bryin
 * @create 2020-05-18 20:01
 */
@RestControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(Exception.class)
    public JSONResult handleException(Exception e){
        return JSONResult.errorMsg("服务器异常");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JSONResult handleException(HttpServletRequest request, HttpServletResponse response,MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringBuilder errMessage = new StringBuilder();
        allErrors.forEach(error -> errMessage.append(error.getDefaultMessage()).append(";"));
        return JSONResult.errorMsg(errMessage.toString());
    }
}
