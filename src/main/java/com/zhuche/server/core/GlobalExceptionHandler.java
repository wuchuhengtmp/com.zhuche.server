/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/23
 * Listen  MIT
 */

package com.zhuche.server.core;

import com.zhuche.server.core.configuration.ErrorCodeConfiguration;
import com.zhuche.server.errors.BaseException;
import com.zhuche.server.errors.BaseExceptionImpl;
import com.zhuche.server.errors.InternalException;
import com.zhuche.server.errors.ValidatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final ErrorCodeConfiguration errorCodeConfiguration;
    private final Integer internalErrorCode = 40000;
    private final String internalMessage = "Internal error";

    public GlobalExceptionHandler(ErrorCodeConfiguration errorCodeConfiguration) {
        this.errorCodeConfiguration = errorCodeConfiguration;
    }

    @ExceptionHandler({BaseExceptionImpl.class})
    public BaseException handle(BaseException e) {
        var message = this.errorCodeConfiguration.getMessage(e.getErrorCode());
        if (message == null ) {
            e.setErrorCode(this.internalErrorCode);
            message = this.internalMessage;

        }
        e.setErrorMessage(message);

        return e;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public  BaseException handle(ConstraintViolationException e) {
        var err = new ValidatedException();
        err.setErrorMessage(e.getMessage());
        Map<String, Object> extensions = err.getExtensions();

        return err;
    }
    
    @ExceptionHandler(RuntimeException.class)
    public InternalException handle(RuntimeException e) {
        var err = new InternalException();
        err.setErrorMessage(this.internalMessage);

        return err;
    }
}
