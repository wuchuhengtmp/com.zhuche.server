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
import com.zhuche.server.errors.InternalException;
import com.zhuche.server.errors.NotFoundException;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.GraphqlErrorException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final ErrorCodeConfiguration errorCodeConfiguration;
    private final Integer internalErrorCode = 40000;
    private final String internalMessage = "Internal error";

    public GlobalExceptionHandler(ErrorCodeConfiguration errorCodeConfiguration) {
        this.errorCodeConfiguration = errorCodeConfiguration;
    }

    @ExceptionHandler({BaseException.class})
    public BaseException handle(BaseException e) {
        var errorCode = e.getErrorCode();
        var message = this.errorCodeConfiguration.getMessage(e.getErrorCode());
        if (message == null ) {
            e.setErrorCode(this.internalErrorCode);
            message = this.internalMessage;

        }
        e.setErrorMessage(message);

        return e;
    }
    
    @ExceptionHandler(RuntimeException.class)
    public InternalException handle(RuntimeException e) {
        var err = new InternalException();
        err.setErrorMessage(this.internalMessage);

        return err;
    }
}
