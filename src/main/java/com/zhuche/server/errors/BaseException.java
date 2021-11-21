/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.errors;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Setter
@Getter
public class BaseException extends RuntimeException implements GraphQLError {
    Integer errorCode = 40000;
    String errorMessage;
    List<SourceLocation> locations = null;
    List<Object> path = null;
    ErrorClassification errorType = null;

    public BaseException(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("errorCode", this.errorCode);

        return  errors;
    }


}
