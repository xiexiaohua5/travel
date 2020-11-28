package com.qf.travel.commons.handler;


import com.qf.travel.commons.exception.ServiceException;
import com.qf.travel.commons.result.BaseResultEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常的处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 返回的是一个大异常，不需要传入一个异常提示
     * 统一的异常，比如参数前端没按要求传递要求的参数
     * 就会下面这个异常，如果不设置捕捉它，抛的就是tomcat的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResultEntity<Object> handlerException(Exception e){
        return BaseResultEntity.error();
    }

    /**
     * 处理service的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public BaseResultEntity<Object> handlerServiceException(ServiceException e){
        return BaseResultEntity.error(e.getCode(),e.getMeg(),e.getTips());
    }
}
