package com.gi.ctdn.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return new Result(200,tips);
    }

    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        logger.error(e.getMessage(),request.getRequestURL());
        return new Result(200,"网络繁忙请稍后再试");
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest request) {
        logger.error(e.getMessage(),request.getRequestURL());
        return new Result(200,"请求错误");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result noHandlerFoundException(Exception e, HttpServletRequest request) {
        logger.error(e.getMessage(),request.getRequestURL());
        return new Result(404,"请求错误");
    }
}