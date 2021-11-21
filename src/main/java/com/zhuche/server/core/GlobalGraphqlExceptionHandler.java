/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.core;

import com.zhuche.server.core.configuration.ErrorCodeConfiguration;
import com.zhuche.server.errors.InternalException;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class GlobalGraphqlExceptionHandler implements GraphQLErrorHandler {
    private final ErrorCodeConfiguration errorCodeConfiguration;

    public GlobalGraphqlExceptionHandler(ErrorCodeConfiguration errorCodeConfiguration) {
        this.errorCodeConfiguration = errorCodeConfiguration;
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        var errors = new ArrayList<GraphQLError>();
        list.forEach(graphQLError -> {
            // 不是自定义异常错误则默认为内部异常错误
            var extensions = graphQLError.getExtensions();
            if (extensions == null || !extensions.containsKey("errorCode")) {
                Integer errorCode = 40000;
                var err = new InternalException(errorCode);
                err.setLocations(graphQLError.getLocations());
                err.setErrorMessage(graphQLError.getMessage());
                err.setPath(graphQLError.getPath());
                err.setErrorType(graphQLError.getErrorType());
                errors.add(err);
            } else {
                errors.add(graphQLError);
            }
        });

        return errors;
    }
}
